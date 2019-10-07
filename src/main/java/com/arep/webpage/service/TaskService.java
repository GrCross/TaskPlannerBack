package com.arep.webpage.service;

import com.arep.webpage.model.Task;


import java.util.List;

/**
 * La clase SchiNotesService representa los servicios que se pueden ofrecer.
 */
public interface TaskService {


    public Task consultarTasksPorCorreo(String email) ;
    public List<Task> consultarTaskPorIdCorreo(String email,Integer id);


}
