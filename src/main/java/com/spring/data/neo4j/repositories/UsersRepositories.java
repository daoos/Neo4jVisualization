package com.spring.data.neo4j.repositories;

import com.spring.data.neo4j.dto.Users;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by Administrator on 2018/3/15.
 */
//@RepositoryRestResource(collectionResourceRel = "users",path = "users")
@Repository
public interface UsersRepositories extends GraphRepository<Users> {
    @Query(value = "MATCH (m:Users) where m.name ={name} return m")
    List<Users> findByName(@Param("name") String name);
}
