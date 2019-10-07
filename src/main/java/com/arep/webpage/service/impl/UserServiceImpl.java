package com.arep.webpage.service.impl;

import com.arep.webpage.dao.UserDAO;
import com.arep.webpage.model.Task;
import com.arep.webpage.model.User;
import com.arep.webpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> consultarUsuarios() {
        return userDAO.loadAll();
    }

    @Override
    public User consultarUsuarioPorCorreo(String correo) {
        return userDAO.loadUserByEmail(correo);
    }

    @Override
    public List<Task> consultarTasksPorCorreo(String email) {
        
        return userDAO.loadTasksUser(email);
    }

    @Override
    public Task consultarTaskPorIdCorreo(String email, Integer id) {
        return userDAO.loadTaskUser(email, id);
    }

    @Override
    public void agregarUsuario(User user) {
        userDAO.addUser(user);

    }

    @Override
    public void agregarTask(String email, Task task) {
        userDAO.addTask(email, task);
    }
}
