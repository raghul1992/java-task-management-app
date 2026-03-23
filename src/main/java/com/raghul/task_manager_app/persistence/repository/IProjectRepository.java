package com.raghul.task_manager_app.persistence.repository;

import com.raghul.task_manager_app.persistence.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IProjectRepository extends CrudRepository<Project, Long> {

}
