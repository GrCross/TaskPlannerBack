package com.arep.webpage.service;

import com.arep.webpage.model.Task;


import java.util.List;
import java.util.Optional;

/**
 *
 */
public interface TaskService {

    public List<Task> consultarTasks();
    public List<Task> consultarTasksPorCorreo(String email) ;
    public Optional<Task> consultarTaskPorIdCorreo(String email,Integer id);
    public void insertarTask(String email,Task task);

}
