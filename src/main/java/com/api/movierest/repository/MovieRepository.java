package com.api.movierest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.movierest.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
