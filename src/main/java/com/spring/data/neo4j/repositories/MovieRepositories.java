package com.spring.data.neo4j.repositories;

import com.spring.data.neo4j.dto.Movie;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

/**
 * Created by Administrator on 2018/3/12.
 */
@RepositoryRestResource(collectionResourceRel = "movies" , path = "movies")
public interface MovieRepositories extends GraphRepository<Movie> {

    @Query("MATCH (m:Movie) where m.title={title} return m")
    Movie findByTitle(@Param("title") String title);

    //Movie findByTitle(@Param("title") String title);

    Collection<Movie> findByTitleLike(@Param("title") String title);

    @Query("MATCH (m:Movie)<-[r:ACTED_IN]-(a:Person) RETURN m,r,a LIMIT {limit}")
    Collection<Movie> graph(@Param("limit") int limit);

    /*@Query("CREATE ({label}:Movie {title:{movie.title},released:{movie.released},tagline:{movie.tagline}})")
    Movie createMovieNode(@Param("movie") Movie movie,@Param("label") String label);*/

}
