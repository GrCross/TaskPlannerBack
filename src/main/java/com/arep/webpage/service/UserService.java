package com.arep.webpage.service;

import com.arep.webpage.model.Task;
import com.arep.webpage.model.User;

import java.util.List;
import java.util.Optional;

/**
 * La clase SchiNotesService representa los servicios que se pueden ofrecer.
 */
public interface UserService {


    public Optional<User> consultarUsuarioPorCorreo(String correo) ;
    public List<User> consultarUsuarios();
    public void agregarUsuario(User user);
}
