package com.TaskManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TaskManager.Entity.Task;
import com.TaskManager.Service.TaskService;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins="*")
public class TaskController {
     @Autowired
     private TaskService taskService;
     
     @PostMapping("/user/{userid}") 
     public ResponseEntity<Task>createTask(@PathVariable Long userid, @RequestBody Task task){
		 return ResponseEntity.ok(taskService.createtask(userid, task));
     }
     
     @GetMapping()
     public ResponseEntity<List<Task>> getAlltask(){
    	 return ResponseEntity.ok(taskService.getAlltask());
     }

     @PutMapping("/{taskId}")
     public ResponseEntity<Task> updateTask(@PathVariable Long taskId, @RequestBody Task task){
    	 return ResponseEntity.ok(taskService.updatetask(taskId, task));
     }
     @DeleteMapping("/{taskId}")
     public ResponseEntity<String> deletetask(@PathVariable Long id){
    	 taskService.deletetask(id);
    	 return ResponseEntity.ok("Task Deleted Successfully");
     }
}
