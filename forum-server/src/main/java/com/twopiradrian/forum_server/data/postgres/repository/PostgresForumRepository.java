package com.twopiradrian.forum_server.data.postgres.repository;

import com.twopiradrian.entity.Category;
import com.twopiradrian.entity.Status;
import com.twopiradrian.forum_server.data.postgres.model.ForumModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PostgresForumRepository extends JpaRepository<ForumModel, String> {

    @Query(
            value = "SELECT f FROM ForumModel f WHERE f.status <> :status ORDER BY f.createdAt DESC"
    )
    Page<ForumModel> findAll(
            @Param("status") Status status,
            Pageable pageable
    );

    @Query(
            value = "SELECT f FROM ForumModel f WHERE f.category = :category " +
                    "AND f.status <> :status ORDER BY f.createdAt DESC"
    )
    Page<ForumModel> findAllByCategory(
            @Param("category") Category category,
            @Param("status") Status status,
            Pageable pageable
    );

    @Query(
            value = "SELECT f FROM ForumModel f WHERE f.createdAt BETWEEN :startDate AND :endDate " +
                    "AND f.status <> :status ORDER BY f.createdAt DESC"
    )
    List<ForumModel> getMonthlyForums(
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate,
            @Param("status") Status status
    );

}
