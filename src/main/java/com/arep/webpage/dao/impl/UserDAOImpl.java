package com.arep.webpage.dao.impl;

import com.arep.webpage.dao.UserDAO;
import com.arep.webpage.model.Task;
import com.arep.webpage.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserDAOImpl implements UserDAO {

    Map<String, User> users = new HashMap<>();


    @Override
    public User loadUserByEmail(String email) {
        User usuario = users.get(email);
        return usuario;
    }

    @Override
    public List<User> loadAll() {

        List<User> users = new ArrayList<>(this.users.values());

        return users;

    }

    @Override
    public List<Task> loadTasksUser(String email) {
        List<Task> tasks = users.get(email).getTasks();
        return tasks;
    }

    @Override
    public Task loadTaskUser(String email, Integer id) {
        Task task = users.get(email).getTasks().get(id);
        return task;
    }


    @Override
    public void addUser(User user) {
        users.put(user.email, user);
    }

    @Override
    public void addTask(String email, Task task) {
        System.out.println(email);
        User user = users.get(email);
        user.addTask(task);
    }
}
