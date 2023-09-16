package com.api.movierest.model.listener;

import java.util.Date;

import com.api.movierest.model.Movie;

import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

public class MovieEntityListener {
    @PrePersist
    public void prePersist(Movie movie) {
        Date now = new Date();
        movie.setCreatedAt(now);
        movie.setUpdatedAt(now);
    }

    @PreUpdate
    public void preUpdate(Movie movie) {
        movie.setUpdatedAt(new Date());
    }
}
