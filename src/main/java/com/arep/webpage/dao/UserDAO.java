package com.arep.webpage.dao;

import com.arep.webpage.model.Task;
import com.arep.webpage.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserDAO  extends MongoRepository<User,String> {

    
}
