package com.astitva.jiraclone.controller;

import com.astitva.jiraclone.entity.Issue;
import com.astitva.jiraclone.entity.SprintIssue;
import com.astitva.jiraclone.service.SprintIssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sprint-issues")
public class SprintIssueController {

    @Autowired
    private SprintIssueService sprintIssueService;

    @PostMapping
    public ResponseEntity<SprintIssue> addIssueToSprint(@RequestParam Long sprintId, @RequestParam Long issueId) {
        return ResponseEntity.ok(sprintIssueService.addIssueToSprint(sprintId, issueId));
    }

    @DeleteMapping
    public ResponseEntity<Void> removeIssueFromSprint(@RequestParam Long sprintId, @RequestParam Long issueId) {
        sprintIssueService.removeIssueFromSprint(sprintId, issueId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/sprint/{sprintId}")
    public ResponseEntity<List<SprintIssue>> getSprintIssueMappings(@PathVariable Long sprintId) {
        return ResponseEntity.ok(sprintIssueService.getIssuesBySprintId(sprintId));
    }

    @GetMapping("/issue/{issueId}")
    public ResponseEntity<List<SprintIssue>> getSprintMappingsForIssue(@PathVariable Long issueId) {
        return ResponseEntity.ok(sprintIssueService.getSprintsByIssueId(issueId));
    }

    // ✅ New endpoint to return full Issue objects in a sprint
    @GetMapping("/sprint/{sprintId}/issues")
    public ResponseEntity<List<Issue>> getAllIssuesInSprint(@PathVariable Long sprintId) {
        return ResponseEntity.ok(sprintIssueService.getFullIssuesBySprintId(sprintId));
    }
}
