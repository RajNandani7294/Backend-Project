package com.TaskManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TaskManager.Entity.Task;

import jakarta.persistence.Entity;
import lombok.Data;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
