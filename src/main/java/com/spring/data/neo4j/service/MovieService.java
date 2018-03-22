package com.spring.data.neo4j.service;

import com.spring.data.neo4j.dto.Movie;
import com.spring.data.neo4j.repositories.MovieRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2018/3/12.
 */
@Service
@Transactional
public class MovieService{

    @Autowired
    private MovieRepositories movieRepositories;

    @Transactional(readOnly = true)
    public Movie findByTitle(String title){
        return movieRepositories.findByTitle(title);
    }

    @Transactional(readOnly = false)
    public Movie createMovieNode(Movie movie){
        if (movieRepositories.findByTitle(movie.getTitle()) != null) {
            System.out.println("------------------>>>进入异常");
            throw new RuntimeException("Record already exists!");
        }
         return movieRepositories.save(movie);
    }

}
