package com.twopiradrian.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Forum {

    private String id;

    private String title;

    private String content;

    private Integer views;

    private String authorId;

    private Set<String> upvoters;

    private Set<String> downvoters;

    private Category category;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    private Status status;

}
