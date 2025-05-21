package com.astitva.jiraclone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sprint_issues")
public class SprintIssue {

    @EmbeddedId
    private SprintIssueId id;

    public SprintIssue() {}

    public SprintIssue(SprintIssueId id) {
        this.id = id;
    }

    public SprintIssueId getId() {
        return id;
    }

    public void setId(SprintIssueId id) {
        this.id = id;
    }
}
