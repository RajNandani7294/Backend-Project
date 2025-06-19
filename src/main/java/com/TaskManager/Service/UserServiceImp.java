package com.TaskManager.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.Entity.User;
import com.TaskManager.Repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User createuser(User user) {
		return userRepository.save(user);
	}

	@Override
	public List<User> getAllusers() {
		return userRepository.findAll();
	}

	@Override
	public User getuserById(Long id) {
	return	userRepository.findById(id)
			.orElseThrow(()->new EntityNotFoundException("User not found with ID:" +id));
		
	}

	@Override
	public Void deleteuser(Long id) {
		userRepository.deleteById(id);
		return null;
	}

}
