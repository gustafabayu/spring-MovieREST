package com.api.movierest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.movierest.model.Movie;
import com.api.movierest.repository.MovieRepository;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieRepository movieRepository;

    // GET all movies
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // GET a single movie by ID
    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
    }

    // POST a new movie
    @PostMapping
    public ResponseEntity<?> addMovie(@Validated @RequestBody Movie movie, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Validation errors: " + bindingResult.getAllErrors());
        }
        return ResponseEntity.ok(movieRepository.save(movie));
    }

    // PATCH (update) a movie by ID
    @PatchMapping("/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        // Update existingMovie fields here
        existingMovie.setTitle(updatedMovie.getTitle());
        existingMovie.setDescription(updatedMovie.getDescription());
        existingMovie.setRating(updatedMovie.getRating());
        existingMovie.setImage(updatedMovie.getImage());
        existingMovie.setCreatedAt(updatedMovie.getCreatedAt());
        existingMovie.setUpdatedAt(updatedMovie.getUpdatedAt());

        return movieRepository.save(existingMovie);
    }

    // DELETE a movie by ID
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable Long id) {
        movieRepository.deleteById(id);
    }
}
