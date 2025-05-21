package com.astitva.jiraclone.service;

import com.astitva.jiraclone.entity.Issue;
import com.astitva.jiraclone.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IssueService {

    @Autowired
    private IssueRepository issueRepository;

    public Issue createIssue(Issue issue) {
        return issueRepository.save(issue);
    }

    public Optional<Issue> getIssueById(Long id) {
        return issueRepository.findById(id);
    }

    public List<Issue> getAllIssues() {
        return issueRepository.findAll();
    }

    public void deleteIssue(Long id) {
        issueRepository.deleteById(id);
    }

    public Issue updateIssue(Long id, Issue updatedIssue) {
        return issueRepository.findById(id).map(issue -> {
            issue.setTitle(updatedIssue.getTitle());
            issue.setDescription(updatedIssue.getDescription());
            issue.setStatus(updatedIssue.getStatus());
            issue.setPriority(updatedIssue.getPriority());
            issue.setAssigneeId(updatedIssue.getAssigneeId());
            issue.setReporterId(updatedIssue.getReporterId());
            return issueRepository.save(issue);
        }).orElseThrow(() -> new RuntimeException("Issue not found"));
    }
}
