package com.astitva.jiraclone.entity;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SprintIssueId implements Serializable {

    private Long sprintId;
    private Long issueId;

    public SprintIssueId() {}

    public SprintIssueId(Long sprintId, Long issueId) {
        this.sprintId = sprintId;
        this.issueId = issueId;
    }

    // Getters and Setters
    public Long getSprintId() {
        return sprintId;
    }

    public void setSprintId(Long sprintId) {
        this.sprintId = sprintId;
    }

    public Long getIssueId() {
        return issueId;
    }

    public void setIssueId(Long issueId) {
        this.issueId = issueId;
    }

    // equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SprintIssueId that)) return false;
        return Objects.equals(sprintId, that.sprintId) && Objects.equals(issueId, that.issueId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sprintId, issueId);
    }
}
