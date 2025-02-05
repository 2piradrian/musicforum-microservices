package com.twopiradrian.forum_server.data.repository;

import com.twopiradrian.entity.Comment;
import com.twopiradrian.entity.PageContent;
import com.twopiradrian.entity.Status;
import com.twopiradrian.forum_server.data.postgres.mapper.CommentEntityMapper;
import com.twopiradrian.forum_server.data.postgres.model.CommentModel;
import com.twopiradrian.forum_server.data.postgres.repository.PostgresCommentRepository;
import com.twopiradrian.forum_server.domain.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class CommentRepositoryI implements CommentRepository {

    private final PostgresCommentRepository commentRepository;

    @Override
    public Comment getById(String commentId) {
        CommentModel commentModel = this.commentRepository.findById(commentId).orElse(null);

        if (commentModel == null) {
            return null;
        }

        if (commentModel.getStatus().equals(Status.DELETED)) {
            commentModel.setAuthorId(Status.DELETED.toString());
            commentModel.setContent(Status.DELETED.toString());

            return CommentEntityMapper.toDomain(commentModel);
        }

        return CommentEntityMapper.toDomain(commentModel);
    }

    @Override
    public PageContent<Comment> getByForumId(String forumId, Integer page, Integer size) {
        Page<CommentModel> commentModels = this.commentRepository.findAllByForumId(forumId, PageRequest.of(page, size));

        return new PageContent<Comment>(
                commentModels.getContent().stream().map(CommentEntityMapper::toDomain).collect(Collectors.toList()),
                commentModels.getNumber(),
                commentModels.hasNext() ? commentModels.getNumber() + 1 : null
        );
    }

    @Override
    public Comment save(Comment comment) {
        CommentModel commentModel = CommentEntityMapper.toModel(comment);
        CommentModel saved = this.commentRepository.save(commentModel);

        return CommentEntityMapper.toDomain(saved);
    }

    @Override
    public Comment update(Comment comment) {
        CommentModel commentModel = CommentEntityMapper.toModel(comment);
        CommentModel updated = this.commentRepository.save(commentModel);

        return CommentEntityMapper.toDomain(updated);
    }

}
