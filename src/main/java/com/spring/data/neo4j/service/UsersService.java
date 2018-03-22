package com.spring.data.neo4j.service;

import com.spring.data.neo4j.dto.Users;
import com.spring.data.neo4j.repositories.UsersRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2018/3/15.
 */
@Service
public class UsersService {
    @Autowired
    private UsersRepositories usersRepositories;

    public List<Users> findByName(String name){
        return usersRepositories.findByName(name);
    };
}
