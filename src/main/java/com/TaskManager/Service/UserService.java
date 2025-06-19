package com.TaskManager.Service;

import java.util.List;

import com.TaskManager.Entity.User;

public interface UserService {
       User createuser(User user);
       List<User> getAllusers();
       User getuserById(Long id);
       Void deleteuser(Long id);
}
