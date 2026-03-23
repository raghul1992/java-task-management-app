package com.raghul.task_manager_app.persistence.repository.impl;

import com.raghul.task_manager_app.persistence.model.Project;
import com.raghul.task_manager_app.persistence.repository.IProjectRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProjectRepositoryImpl implements IProjectRepository {

    private static final Logger log = LoggerFactory.getLogger(ProjectRepositoryImpl.class);
    List<Project> projects = new ArrayList<>();

/*
    @Value("${project.prefix}")
    private  String prefix;

    @Value("${project.suffix}")
    private String suffix;
*/



    public ProjectRepositoryImpl(){
        super();
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Project save(Project project) {
        Project existingProject = findById(project.getId()).orElse(null);
        updateInternalId(project);
        if (existingProject == null){
            projects.add(project);
        } else {
            projects.remove(existingProject);
            Project newProject = new Project(project);
            projects.add(newProject);
        }
        return project;
    }

    private void updateInternalId(Project project){
      //  log.info("prepending prefix  :  "+prefix);
      //  log.info("appending suffix   :  "+suffix);

     //   project.setInternalId(prefix + "-" + project.getId() + "-" + suffix);
        project.setInternalId( project.getId() + "-" );

       // log.info("generated id  :  "+project.getId());
    }

}
