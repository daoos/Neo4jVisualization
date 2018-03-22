package com.spring.data.neo4j.repositories;

import com.spring.data.neo4j.dto.Login;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Administrator on 2018/3/17.
 */
@Repository
@RepositoryRestResource(collectionResourceRel = "login" , path = "login")
public interface LoginRepository extends GraphRepository<Login> {

    List<Login> findByUser(@Param("user") String user);

    @Query("match (n:Login) where n.{type}={value} return n")
    List<Login> findBy(@Param("type") String type,@Param("value") Object value);


    @Query("MATCH (m:Login) return m")
    List<Login> findAllLogin();
}
