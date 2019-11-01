package com.arep.webpage.dao;

import com.arep.webpage.model.Task;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface TaskDAO extends MongoRepository<Task, Integer> {

    List<Task> findByUserOwner(String userOwner);
    Optional<Task> findByIdAndUserOwner(Integer taskId, String userOwner);
    Integer findByIdGreaterThan();
}
