package com.astitva.jiraclone.controller;

import com.astitva.jiraclone.entity.Project;
import com.astitva.jiraclone.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@Tag(name = "Project API", description = "Operations related to project management")
public class ProjectsController {

    @Autowired
    private ProjectService projectService;

    @Operation(
            summary = "Create a new project",
            requestBody = @RequestBody(
                    required = true,
                    description = "Project object to be created",
                    content = @Content(schema = @Schema(implementation = Project.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Project created successfully"),
                    @ApiResponse(responseCode = "400", description = "Invalid input")
            }
    )
    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project) {
        return ResponseEntity.ok(projectService.createProject(project));
    }

    @Operation(
            summary = "Get all projects",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of projects",
                            content = @Content(schema = @Schema(implementation = Project.class)))
            }
    )
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        return ResponseEntity.ok(projectService.getAllProjects());
    }

    @Operation(
            summary = "Get project by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Project found"),
                    @ApiResponse(responseCode = "404", description = "Project not found")
            }
    )
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        return projectService.getProjectById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Update a project",
            requestBody = @RequestBody(
                    required = true,
                    description = "Updated project data",
                    content = @Content(schema = @Schema(implementation = Project.class))
            ),
            responses = {
                    @ApiResponse(responseCode = "200", description = "Project updated"),
                    @ApiResponse(responseCode = "404", description = "Project not found")
            }
    )
    @PutMapping("/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {
        return projectService.updateProject(id, updatedProject)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(
            summary = "Delete a project",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Project deleted"),
                    @ApiResponse(responseCode = "404", description = "Project not found")
            }
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        if (projectService.deleteProject(id)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
