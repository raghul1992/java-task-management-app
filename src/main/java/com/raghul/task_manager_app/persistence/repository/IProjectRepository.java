package com.raghul.task_manager_app.persistence.repository;

import com.raghul.task_manager_app.persistence.model.Project;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IProjectRepository extends CrudRepository<Project, Long> {

    Optional<Project> findByName(String name);

    List<Project> findByDateCreatedBetween(LocalDate startDate, LocalDate endDate);
}
