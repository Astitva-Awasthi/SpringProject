package com.astitva.jiraclone.repository;

import com.astitva.jiraclone.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Long> {
    // You can add methods like:
    // List<Issue> findByProjectId(Long projectId);
}
