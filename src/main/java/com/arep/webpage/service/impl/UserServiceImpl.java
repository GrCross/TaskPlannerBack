package com.arep.webpage.service.impl;

import com.arep.webpage.dao.UserDAO;
import com.arep.webpage.model.Task;
import com.arep.webpage.model.User;
import com.arep.webpage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    @Override
    public List<User> consultarUsuarios() {
        return userDAO.findAll();
    }

    @Override
    public Optional<User> consultarUsuarioPorCorreo(String correo) {
        return userDAO.findById(correo);
    }

    @Override
    public void agregarUsuario(User user) { userDAO.insert(user); }

}
