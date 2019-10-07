package com.arep.webpage.service.impl;

import com.arep.webpage.dao.UserDAO;
import com.arep.webpage.model.Task;
import com.arep.webpage.model.User;
import com.arep.webpage.service.TaskService;
import com.arep.webpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public Task consultarTasksPorCorreo(String email) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Task> consultarTaskPorIdCorreo(String email, Integer id) {
        // TODO Auto-generated method stub
        return null;
    }
}
