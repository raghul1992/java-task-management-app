package com.raghul.task_manager_app.repository;


import com.raghul.task_manager_app.persistence.model.Project;
import com.raghul.task_manager_app.persistence.repository.IProjectRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.apache.commons.lang3.RandomStringUtils.randomAlphabetic;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringBootTest
public class ProjectRepositoryIntegrationTest {

    @Autowired
    private IProjectRepository projectRepository;

    @Test
    public void whenSavingNewProject_thenSuccess(){
        Project project = new Project(randomAlphabetic(6), LocalDate.now());
        assertThat(projectRepository.save(project),is(notNullValue()));
    }

    @Test
    public void givenProject_whenFindById_thenSuccess(){
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retrieveProject = projectRepository.findById(newProject.getId());
        assertThat(retrieveProject.get(),is(equalTo(newProject)));
    }

    @Test
    public void givenProject_whenFindByName_thenSuccess(){
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);

        Optional<Project> retrieveProject = projectRepository.findByName(newProject.getName());
        assertThat(retrieveProject.get(),is(equalTo(newProject)));
    }

    @Test
    public void givenProjectCreated_whenFindByDateCreatedBetween_thenSuccess(){
        Project oldProject = new Project(randomAlphabetic(6), LocalDate.now().minusYears(1));
        projectRepository.save(oldProject);
        Project newProject = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject);
        Project newProject2 = new Project(randomAlphabetic(6), LocalDate.now());
        projectRepository.save(newProject2);
        List<Project> retrievedProjects = projectRepository.findByDateCreatedBetween(LocalDate.now().minusDays(1),LocalDate.now().plusDays(1));
        assertThat(retrievedProjects,hasItems(newProject,newProject2));




    }

}
