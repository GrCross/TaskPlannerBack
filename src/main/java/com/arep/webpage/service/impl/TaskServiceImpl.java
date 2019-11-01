package com.arep.webpage.service.impl;

import com.arep.webpage.dao.TaskDAO;
import com.arep.webpage.dao.UserDAO;
import com.arep.webpage.model.Task;
import com.arep.webpage.model.User;
import com.arep.webpage.service.TaskService;
import com.arep.webpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;


import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDAO taskDAO;

    @Override
    public List<Task> consultarTasks() {
        return taskDAO.findAll();
    }

    @Override
    public List<Task> consultarTasksPorCorreo(String email) {
        return taskDAO.findByUserOwner(email);
    }

    @Override
    public Optional<Task> consultarTaskPorIdCorreo(String email, Integer id) {
        return taskDAO.findByIdAndUserOwner(id,email);
    }

    @Override
    public void insertarTask(String email,Task task) {
        Integer maxId = this.consultarTasks().size();
        task.setTaskId(maxId+1);
        taskDAO.insert(task);
    }
}
