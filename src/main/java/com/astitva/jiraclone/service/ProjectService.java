package com.astitva.jiraclone.service;

import com.astitva.jiraclone.entity.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

    Project createProject(Project project);

    List<Project> getAllProjects();

    Optional<Project> getProjectById(Long id);

    Optional<Project> updateProject(Long id, Project updatedProject);

    boolean deleteProject(Long id);
}
