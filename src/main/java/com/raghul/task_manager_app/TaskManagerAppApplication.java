package com.raghul.task_manager_app;

import com.raghul.task_manager_app.persistence.model.Project;
import com.raghul.task_manager_app.service.IProjectService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class TaskManagerAppApplication {

	@Autowired
	IProjectService projectService;

	public static void main(String[] args) {
		SpringApplication.run(TaskManagerAppApplication.class, args);
	}

	@PostConstruct
	public void postConstruct(){
		//projectService.save(new Project(1L, "First project", LocalDate.now()));
	}

}
