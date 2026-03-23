package com.raghul.task_manager_app.service.impl;

import com.raghul.task_manager_app.persistence.model.Project;
import com.raghul.task_manager_app.persistence.repository.IProjectRepository;
import com.raghul.task_manager_app.service.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProjectServiceImpl implements IProjectService {

   @Autowired
   private IProjectRepository projectRepo;

    @Override
    public Optional<Project> findById(Long id) {
        return projectRepo.findById(id);
    }

    @Override
    public Project save(Project project) {
        return projectRepo.save(project);
    }
}
