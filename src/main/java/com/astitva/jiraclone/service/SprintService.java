package com.astitva.jiraclone.service;

import com.astitva.jiraclone.entity.Sprint;
import com.astitva.jiraclone.repository.SprintRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    public Sprint createSprint(Sprint sprint) {
        return sprintRepository.save(sprint);
    }

    public Optional<Sprint> getSprintById(Long id) {
        return sprintRepository.findById(id);
    }

    public List<Sprint> getAllSprints() {
        return sprintRepository.findAll();
    }

    public List<Sprint> getSprintsByProjectId(Long projectId) {
        return sprintRepository.findByProjectId(projectId);
    }

    public void deleteSprint(Long id) {
        sprintRepository.deleteById(id);
    }

    public Sprint updateSprint(Long id, Sprint updatedSprint) {
        return sprintRepository.findById(id).map(sprint -> {
            sprint.setName(updatedSprint.getName());
            sprint.setStartDate(updatedSprint.getStartDate());
            sprint.setEndDate(updatedSprint.getEndDate());
            sprint.setProjectId(updatedSprint.getProjectId());
            return sprintRepository.save(sprint);
        }).orElseThrow(() -> new RuntimeException("Sprint not found"));
    }
}
