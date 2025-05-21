package com.astitva.jiraclone.repository;

import com.astitva.jiraclone.entity.SprintIssue;
import com.astitva.jiraclone.entity.SprintIssueId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SprintIssueRepository extends JpaRepository<SprintIssue, SprintIssueId> {
    List<SprintIssue> findByIdSprintId(Long sprintId);
    List<SprintIssue> findByIdIssueId(Long issueId);
}
