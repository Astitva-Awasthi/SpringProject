package com.astitva.jiraclone.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or SEQUENCE based on Oracle setup
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(name = "project_key", nullable = false, unique = true, length = 50)
    private String projectKey;

    @Column(length = 1000)
    private String description;

    @Column(name = "owner_id")
    private Long ownerId;

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProjectKey() {
        return projectKey;
    }

    public void setProjectKey(String projectKey) {
        this.projectKey = projectKey;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
