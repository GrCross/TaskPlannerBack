package com.arep.webpage.dao.impl;

import com.arep.webpage.dao.UserDAO;
import com.arep.webpage.model.Task;
import com.arep.webpage.model.User;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@Service
public class UserDAOImpl {

    Map<String, User> users = new HashMap<>();


    //@Override
    public User loadUserByEmail(String email) {
        User usuario = users.get(email);
        return usuario;
    }

    //@Override
    public List<User> loadAll() {

        List<User> users = new ArrayList<>(this.users.values());
        System.out.println();
        return users;

    }


    //@Override
    public void addUser(User user) {
        users.put(user.email, user);
    }

}
