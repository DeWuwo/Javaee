package com.example.demo.model.repository;

import com.example.demo.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
    void deleteUserById(int id);
    List<User> findUsersByParentId(int parentId);

}
