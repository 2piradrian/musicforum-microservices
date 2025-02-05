package com.twopiradrian.forum_server.presentation.controller;

import com.twopiradrian.forum_server.domain.dto.forum.mapper.ForumMapper;
import com.twopiradrian.forum_server.domain.dto.forum.request.*;
import com.twopiradrian.forum_server.presentation.service.ForumService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/forum")
public class ForumController {

    private final ForumService forumService;

    @GetMapping("/get-by-id/{forumId}")
    public ResponseEntity<?> getById(
            @PathVariable(value = "forumId") String forumId
    ) {
        GetForumByIdReq dto = ForumMapper.getById().toRequest(forumId);

        return ResponseEntity.ok(this.forumService.getById(dto));
    }

    @GetMapping("/get-forums")
    public ResponseEntity<?> getForums(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "size") Integer size,
            @RequestParam(value = "page") Integer page
    ) {
        GetForumPageReq dto = ForumMapper.getPage().toRequest(category, size, page);

        return ResponseEntity.ok(this.forumService.getForums(dto));
    }

    @GetMapping("/get-monthly-forums")
    public ResponseEntity<?> getMonthlyForums(
            @RequestHeader(value = "Authorization") String token,
            @RequestParam(value = "month") Integer month,
            @RequestParam(value = "year") Integer year
    ) {
        GetMonthlyForumsReq dto = ForumMapper.getMonthly().toRequest(token, month, year);

        return ResponseEntity.ok(this.forumService.getMonthlyForums(dto));
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody Map<String, Object> payload
    ) {
        CreateForumReq dto = ForumMapper.create().toRequest(token, payload);

        return ResponseEntity.ok(this.forumService.create(dto));
    }

    @PatchMapping("/edit")
    public ResponseEntity<?> edit(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody Map<String, Object> payload
    ) {
        EditForumReq dto = ForumMapper.edit().toRequest(token, payload);

        return ResponseEntity.ok(this.forumService.edit(dto));
    }

    @PatchMapping("/toggle-votes")
    public ResponseEntity<?> toggleVotes(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody Map<String, Object> payload
    ) {
        ToggleForumVotesReq dto = ForumMapper.toggleVotes().toRequest(token, payload);
        this.forumService.toggleVotes(dto);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(
            @RequestHeader(value = "Authorization") String token,
            @RequestBody Map<String, Object> payload
    ) {
        DeleteForumReq dto = ForumMapper.delete().toRequest(token, payload);
        this.forumService.delete(dto);

        return ResponseEntity.ok().build();
    }

}
