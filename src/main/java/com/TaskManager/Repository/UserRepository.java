package com.TaskManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskManager.Entity.User;

public interface UserRepository extends JpaRepository<User,Long> {

	

}
