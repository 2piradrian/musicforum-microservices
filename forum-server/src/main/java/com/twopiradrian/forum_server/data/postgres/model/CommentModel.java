package com.twopiradrian.forum_server.data.postgres.model;

import com.twopiradrian.entity.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comments")
public class CommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String authorId;

    @Column(name = "forum_id", nullable = false)
    private String forumId;

    @ManyToOne
    private CommentModel replyTo;

    @Column(columnDefinition = "TEXT")
    private String content;

    private Set<String> upvoters;

    private Set<String> downvoters;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @Enumerated(EnumType.STRING)
    private Status status;

}
