package com.TaskManager.Service;

import java.util.List;

import com.TaskManager.Entity.Task;

public interface TaskService {

	Task createtask(Long userid, Task task);
	List<Task> getAlltask();
	Task getTaskById(Long id);
	Task updatetask(Long taskid, Task task);
	void deletetask(Long taskid);
}
