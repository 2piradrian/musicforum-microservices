package com.twopiradrian.forum_server.presentation.service;

import com.twopiradrian.entity.*;
import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import com.twopiradrian.forum_server.data.repository.AuthRepositoryI;
import com.twopiradrian.forum_server.data.repository.ForumRepositoryI;
import com.twopiradrian.forum_server.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.forum_server.domain.dto.forum.request.*;
import com.twopiradrian.forum_server.domain.dto.forum.response.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class ForumServiceI implements ForumService {

    private final ForumRepositoryI forumRepository;
    private final AuthRepositoryI authRepository;

    @Override
    public GetForumByIdRes getById(GetForumByIdReq dto) {
        Forum forum = this.forumRepository.getById(dto.getForumId());
        if(forum == null) throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);

        User author = this.authRepository.getById(forum.getAuthorId());
        if(author == null) throw new ErrorHandler(ErrorType.USER_NOT_FOUND);

        Integer views = forum.getViews();
        forum.setViews(views + 1);

        this.forumRepository.update(forum);

        return ForumMapper.getById().toResponse(forum, author);
    }

    @Override
    public GetForumPageRes getForums(GetForumPageReq dto) {
        PageContent<Forum> forums =
                this.forumRepository.getAllForums(dto.getPage(), dto.getSize(), dto.getCategory());

        return ForumMapper.getPage().toResponse(forums);
    }

    @Override
    public GetMonthlyForumsRes getMonthlyForums(GetMonthlyForumsReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());

        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        boolean isAdmin = claims.getRoles().contains(Role.ADMIN);
        if (!isAdmin) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        List<Forum> forums =
                this.forumRepository.getMonthlyForums(dto.getMonth(), dto.getYear());

        return ForumMapper.getMonthly().toResponse(forums);
    }

    @Override
    public CreateForumRes create(CreateForumReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Forum forum = new Forum();

        forum.setAuthorId(claims.getId());
        forum.setTitle(dto.getTitle());
        forum.setContent(dto.getContent());
        forum.setCategory(dto.getCategory());
        forum.setStatus(Status.ACTIVE);

        forum.setViews(0);
        forum.setUpvoters(Set.of());
        forum.setDownvoters(Set.of());
        forum.setCreatedAt(LocalDateTime.now());
        forum.setUpdatedAt(LocalDateTime.now());

        Forum saved = this.forumRepository.save(forum);

        return ForumMapper.create().toResponse(saved);
    }

    @Override
    public EditForumRes edit(EditForumReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Forum forum = this.forumRepository.getById(dto.getForumId());
        if (forum == null) throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);

        if (!forum.getAuthorId().equals(claims.getId())) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        forum.setTitle(dto.getTitle());
        forum.setContent(dto.getContent());
        forum.setCategory(dto.getCategory());
        forum.setUpdatedAt(LocalDateTime.now());

        Forum edited = this.forumRepository.update(forum);
        return ForumMapper.edit().toResponse(edited);
    }

    @Override
    public void toggleVotes(ToggleForumVotesReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Forum forum = this.forumRepository.getById(dto.getForumId());
        if (forum == null) throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);

        String user = claims.getId();

        Set<String> upvoters = forum.getUpvoters();
        Set<String> downvoters = forum.getDownvoters();

        if (Vote.UPVOTE == dto.getVoteType()) {
            if (upvoters.contains(user)) {
                upvoters.remove(user);
            }
            else {
                upvoters.add(user);
                downvoters.remove(user);
            }
        }
        if (Vote.DOWNVOTE == dto.getVoteType()) {
            if (downvoters.contains(user)) {
                downvoters.remove(user);
            }
            else {
                downvoters.add(user);
                upvoters.remove(user);
            }
        }

        forum.setUpvoters(upvoters);
        forum.setDownvoters(downvoters);

        this.forumRepository.update(forum);
    }

    @Override
    public void delete(DeleteForumReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Forum forum = this.forumRepository.getById(dto.getForumId());
        if (forum == null) throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);

        boolean isAuthor = forum.getAuthorId().equals(claims.getId());
        boolean isAdmin = claims.getRoles().contains(Role.ADMIN);
        boolean isModerator = claims.getRoles().contains(Role.MODERATOR);

        if (!isAuthor && !isAdmin && !isModerator) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        forum.setUpdatedAt(LocalDateTime.now());
        forum.setStatus(Status.DELETED);

        this.forumRepository.update(forum);
    }

}
