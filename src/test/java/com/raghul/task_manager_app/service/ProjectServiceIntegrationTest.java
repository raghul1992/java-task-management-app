package com.raghul.task_manager_app.service;


import com.raghul.task_manager_app.persistence.model.Project;
import com.raghul.task_manager_app.spring.TestConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

@SpringJUnitConfig(classes = TestConfig.class)
public class ProjectServiceIntegrationTest {


    @Autowired
    private IProjectService projectService;

    @Test
    public void whenSavingProject_thenOK(){
        Project savedProject = projectService.save(new Project("new project 2 ", LocalDate.now()));

        assertThat(savedProject,is(notNullValue()));

    }


}
