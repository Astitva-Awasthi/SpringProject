package com.astitva.jiraclone.service;

import com.astitva.jiraclone.entity.Project;
import com.astitva.jiraclone.repository.ProjectRepository;
import com.astitva.jiraclone.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public Optional<Project> updateProject(Long id, Project updatedProject) {
        return projectRepository.findById(id).map(existingProject -> {
            existingProject.setName(updatedProject.getName());
            existingProject.setProjectKey(updatedProject.getProjectKey());
            existingProject.setDescription(updatedProject.getDescription());
            existingProject.setOwnerId(updatedProject.getOwnerId());
            return projectRepository.save(existingProject);
        });
    }

    @Override
    public boolean deleteProject(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
