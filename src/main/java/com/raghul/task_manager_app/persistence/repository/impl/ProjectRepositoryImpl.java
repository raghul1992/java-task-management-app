/*
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

*/
/*
    @Value("${project.prefix}")
    private  String prefix;

    @Value("${project.suffix}")
    private String suffix;
*//*




    public ProjectRepositoryImpl(){
        super();
    }

    @Override
    public <S extends Project> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Project> findById(Long id) {
        return projects.stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Project> findAll() {
        return null;
    }

    @Override
    public Iterable<Project> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Project entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Project> entities) {

    }

    @Override
    public void deleteAll() {

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
*/
