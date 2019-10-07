package com.arep.webpage.dao;

import com.arep.webpage.model.Task;
import com.arep.webpage.model.User;

import java.util.List;

public interface UserDAO {

    public User loadUserByEmail(String email);
    public List<User> loadAll();
    public List<Task> loadTasksUser(String email);
    public Task loadTaskUser(String email,Integer id);
    public void addUser(User user);
    public void addTask(String email,Task task);
    
}
