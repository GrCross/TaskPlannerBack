package com.arep.webpage.service;

import com.arep.webpage.model.Task;
import com.arep.webpage.model.User;

import java.util.List;

/**
 * La clase SchiNotesService representa los servicios que se pueden ofrecer.
 */
public interface UserService {


    public User consultarUsuarioPorCorreo(String correo) ;
    public List<User> consultarUsuarios();
    public List<Task> consultarTasksPorCorreo(String email) ;
    public Task consultarTaskPorIdCorreo(String email,Integer id);
    public void agregarUsuario(User user);
    public void agregarTask(String email,Task task);

}
