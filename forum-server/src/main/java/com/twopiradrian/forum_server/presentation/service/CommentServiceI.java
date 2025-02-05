package com.twopiradrian.forum_server.presentation.service;

import com.twopiradrian.entity.*;
import com.twopiradrian.error.ErrorHandler;
import com.twopiradrian.error.ErrorType;
import com.twopiradrian.forum_server.data.repository.AuthRepositoryI;
import com.twopiradrian.forum_server.data.repository.CommentRepositoryI;
import com.twopiradrian.forum_server.data.repository.ForumRepositoryI;
import com.twopiradrian.forum_server.domain.dto.comment.mapper.CommentMapper;
import com.twopiradrian.forum_server.domain.dto.comment.request.*;
import com.twopiradrian.forum_server.domain.dto.comment.response.CreateCommentRes;
import com.twopiradrian.forum_server.domain.dto.comment.response.EditCommentRes;
import com.twopiradrian.forum_server.domain.dto.comment.response.GetCommentPageRes;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class CommentServiceI implements CommentService {

    private final CommentRepositoryI commentRepository;
    private final ForumRepositoryI forumRepository;
    private final AuthRepositoryI authRepository;

    @Override
    public GetCommentPageRes getComments(GetCommentPageReq dto) {
        Forum forum = this.forumRepository.getById(dto.getForumId());
        if(forum == null) throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);

        if (forum.getStatus() == Status.DELETED) {
            throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);
        }

        PageContent<Comment> comments =
                this.commentRepository.getByForumId(dto.getForumId(), dto.getPage(), dto.getSize());

        return CommentMapper.getPage().toResponse(comments);
    }

    @Override
    public CreateCommentRes create(CreateCommentReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Forum forum = this.forumRepository.getById(dto.getForumId());
        if(forum == null) throw new ErrorHandler(ErrorType.FORUM_NOT_FOUND);

        if (forum.getStatus() != Status.ACTIVE) {
            throw new ErrorHandler(ErrorType.FORUM_NOT_ACTIVE);
        }

        Comment comment = new Comment();

        comment.setAuthorId(claims.getId());
        comment.setForumId(forum.getId());
        comment.setContent(dto.getContent());
        comment.setUpvoters(Set.of());
        comment.setDownvoters(Set.of());
        comment.setCreatedAt(LocalDateTime.now());
        comment.setUpdatedAt(LocalDateTime.now());
        comment.setStatus(Status.ACTIVE);

        if (dto.getReplyTo() != null) {
            Comment replyTo = this.commentRepository.getById(dto.getReplyTo());
            if (replyTo == null) throw new ErrorHandler(ErrorType.COMMENT_NOT_FOUND);
            comment.setReplyTo(replyTo);
        }

        Comment saved = this.commentRepository.save(comment);

        return CommentMapper.create().toResponse(saved);
    }

    @Override
    public EditCommentRes edit(EditCommentReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Comment comment = this.commentRepository.getById(dto.getCommentId());
        if (comment == null) throw new ErrorHandler(ErrorType.COMMENT_NOT_FOUND);

        if (!comment.getAuthorId().equals(claims.getId())) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        comment.setContent(dto.getContent());
        comment.setUpdatedAt(LocalDateTime.now());

        Comment edited = this.commentRepository.update(comment);
        return CommentMapper.edit().toResponse(edited);
    }

    @Override
    public void toggleVotes(ToggleCommentVotesReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Comment comment = this.commentRepository.getById(dto.getCommentId());
        if (comment == null) throw new ErrorHandler(ErrorType.COMMENT_NOT_FOUND);

        String user = claims.getId();

        Set<String> upvoters = comment.getUpvoters();
        Set<String> downvoters = comment.getDownvoters();

        if (Vote.UPVOTE == dto.getVoteType()) {
            if (upvoters.contains(user)) {
                upvoters.remove(user);
            } else {
                upvoters.add(user);
                downvoters.remove(user);
            }
        }
        if (Vote.DOWNVOTE == dto.getVoteType()) {
            if (downvoters.contains(user)) {
                downvoters.remove(user);
            } else {
                downvoters.add(user);
                upvoters.remove(user);
            }
        }

        comment.setUpvoters(upvoters);
        comment.setDownvoters(downvoters);

        this.commentRepository.update(comment);
    }

    @Override
    public void delete(DeleteCommentReq dto) {
        TokenClaims claims = this.authRepository.auth(dto.getToken());
        if (claims == null) throw new ErrorHandler(ErrorType.UNAUTHORIZED);

        Comment comment = this.commentRepository.getById(dto.getCommentId());
        if (comment == null) throw new ErrorHandler(ErrorType.COMMENT_NOT_FOUND);

        boolean isAuthor = comment.getAuthorId().equals(claims.getId());
        boolean isAdmin = claims.getRoles().contains(Role.ADMIN);
        boolean isModerator = claims.getRoles().contains(Role.MODERATOR);

        if (!isAuthor && !isAdmin && !isModerator) {
            throw new ErrorHandler(ErrorType.UNAUTHORIZED);
        }

        comment.setUpdatedAt(LocalDateTime.now());
        comment.setStatus(Status.DELETED);

        this.commentRepository.update(comment);
    }

}
