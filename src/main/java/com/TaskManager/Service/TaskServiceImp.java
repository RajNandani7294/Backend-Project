package com.TaskManager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.Entity.Task;
import com.TaskManager.Entity.User;
import com.TaskManager.Repository.TaskRepository;
import com.TaskManager.Repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TaskServiceImp implements TaskService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TaskRepository taskRepository;

	@Override
	public Task createtask(Long userid, Task task) {
		User user = userRepository.findById(userid)
		    .orElseThrow(()-> new EntityNotFoundException("User not found with ID:" +userid));
		      task.setAssignedUser(user);
		return taskRepository.save(task);
	}

	@Override
	public List<Task> getAlltask() {
		return taskRepository.findAll();
	}

	@Override
	public Task getTaskById(Long id) {
		return taskRepository.findById(id)
				.orElseThrow(()->new EntityNotFoundException("User not found with ID:" +id));
	}

	@Override
	public Task updatetask(Long id, Task updatetask) {
		Task existingTask = getTaskById(id);
		existingTask.setTitle(updatetask.getTitle());
		existingTask.setDescription(updatetask.getDescription());
		existingTask.setStatus(updatetask.getStatus());
		return taskRepository.save(existingTask);
	}

	@Override
	public void deletetask(Long id) {
		taskRepository.deleteById(id);
	}
   
}
