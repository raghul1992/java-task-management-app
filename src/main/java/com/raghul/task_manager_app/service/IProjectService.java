package com.raghul.task_manager_app.service;

import com.raghul.task_manager_app.persistence.model.Project;

import java.util.Optional;

public interface IProjectService {
    Optional<Project> findById(Long id);
    Project save(Project project);
}
