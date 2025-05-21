package com.astitva.jiraclone.repository;

import com.astitva.jiraclone.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    // Additional query methods can be added here if needed
}
