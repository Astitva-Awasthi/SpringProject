package com.astitva.jiraclone.service;

import com.astitva.jiraclone.entity.Issue;
import com.astitva.jiraclone.entity.SprintIssue;
import com.astitva.jiraclone.entity.SprintIssueId;
import com.astitva.jiraclone.repository.IssueRepository;
import com.astitva.jiraclone.repository.SprintIssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintIssueService {

    @Autowired
    private SprintIssueRepository sprintIssueRepository;

    @Autowired
    private IssueRepository issueRepository;

    public SprintIssue addIssueToSprint(Long sprintId, Long issueId) {
        SprintIssueId id = new SprintIssueId(sprintId, issueId);
        SprintIssue sprintIssue = new SprintIssue(id);
        return sprintIssueRepository.save(sprintIssue);
    }

    public void removeIssueFromSprint(Long sprintId, Long issueId) {
        SprintIssueId id = new SprintIssueId(sprintId, issueId);
        sprintIssueRepository.deleteById(id);
    }

    public List<SprintIssue> getIssuesBySprintId(Long sprintId) {
        return sprintIssueRepository.findByIdSprintId(sprintId);
    }

    public List<SprintIssue> getSprintsByIssueId(Long issueId) {
        return sprintIssueRepository.findByIdIssueId(issueId);
    }

    public List<Issue> getFullIssuesBySprintId(Long sprintId) {
        List<SprintIssue> sprintIssues = sprintIssueRepository.findByIdSprintId(sprintId);
        List<Long> issueIds = sprintIssues.stream()
                .map(s -> s.getId().getIssueId())
                .toList();
        return issueRepository.findAllById(issueIds);
    }

}
