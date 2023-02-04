package com.app.moviecharactersapi.service;

import com.app.moviecharactersapi.dto.movie.PostMovieDto;
import com.app.moviecharactersapi.model.Character;
import com.app.moviecharactersapi.model.Movie;
import com.app.moviecharactersapi.repository.MovieRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final CharacterService characterService;

    public MovieService(MovieRepository movieRepository, CharacterService characterService) {
        this.movieRepository = movieRepository;
        this.characterService = characterService;
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    @Transactional
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie getMovieById(Integer id) {
        Optional<Movie> result = movieRepository.findById(id);
        return result.orElse(null);
    }

    @Transactional
    public Movie updateMovie(Integer id, PostMovieDto movie) {
        Movie existingMovie = getMovieById(id);
        if (existingMovie != null) {
            existingMovie.setMovieTitle(movie.getMovieTitle());
            existingMovie.setGenre(movie.getGenre());
            existingMovie.setDirector(movie.getDirector());
            existingMovie.setPicture(movie.getPicture());
            existingMovie.setTrailer(movie.getTrailer());
            existingMovie.setReleaseYear(movie.getReleaseYear());
            return movieRepository.save(existingMovie);
        } else {
            throw new RuntimeException("There is no movie against this ID");
        }

    }

    @Transactional
    public ResponseEntity<?> deleteMovie(Integer id) {
        Movie movie = getMovieById(id);
        if (movie != null) {
            movie.setCharacters(null);
            movie.setFranchise(null);
            Movie afterUpdating = movieRepository.save(movie);
            movieRepository.delete(afterUpdating);
            return new ResponseEntity<>("Movie has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There is no movie against this ID", HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public ResponseEntity<?> updateCharactersInMovie(Integer movieId, List<Integer> charactersIdsList) {
        Movie existingMovie = getMovieById(movieId);
        if (existingMovie != null) {
            for (Integer characterId : charactersIdsList
            ) {
                Character character = characterService.getCharacterById(characterId);
                if (character != null && !existingMovie.getCharacters().contains(character)) {
                    existingMovie.getCharacters().add(character);
                }
            }
            return new ResponseEntity<>("Character has been added in the movie", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There is no movie against this ID", HttpStatus.BAD_REQUEST);
        }
    }

    public List<Character> getAllCharactersOfMovie(Integer id) {
        Optional<Movie> result = movieRepository.findById(id);
        if (result.isPresent()) {
            return result.get().getCharacters();
        } else {
            throw new RuntimeException("There is no movie against this ID");
        }
    }
}
