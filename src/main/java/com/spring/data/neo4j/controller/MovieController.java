package com.spring.data.neo4j.controller;

import com.spring.data.neo4j.dto.Movie;
import com.spring.data.neo4j.dto.Users;
import com.spring.data.neo4j.service.MovieService;
import com.spring.data.neo4j.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Administrator on 2018/3/12.
 */
@Controller
public class MovieController {
    final MovieService movieService;

    @Autowired
    private UsersService usersService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }


    @RequestMapping("/createNode")
    @Transactional(readOnly = false)
    public Movie createNode(){
        Movie movie=new Movie("功夫",2000,"中国功夫好啊！真滴好！");
        return movieService.createMovieNode(movie);
    }

    @RequestMapping("/findByTitle/{title}")
    public Movie findByTitle(@PathVariable("title") String title){
        return movieService.findByTitle(title);
    }

    @RequestMapping("/findByName/{name}")
    public List<Users> findByName(@PathVariable("name") String name){
        System.out.println("--->"+name);
        return usersService.findByName(name);
    }

}
