package com.TaskManager.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TaskManager.Entity.User;
import com.TaskManager.Repository.UserRepository;
import com.TaskManager.Service.UserService;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	 private UserService userService;
	
	@PostMapping
	public ResponseEntity<User>createuser(@RequestBody User user){
		return ResponseEntity.ok(userService.createuser(user));
	}
	
	@GetMapping
	public ResponseEntity<List<User>> getAlluser(){
		return ResponseEntity.ok(userService.getAllusers());
	}
	@GetMapping("/{id}")
	public ResponseEntity<User>getuserById(@PathVariable Long id){
		return ResponseEntity.ok(userService.getuserById(id));
	}
	@DeleteMapping("{id}")
	public  ResponseEntity<String> deleteuser(@PathVariable Long id){
		userService.deleteuser(id);
		return ResponseEntity.ok("User Deleted Successfully"); 
	}
}
