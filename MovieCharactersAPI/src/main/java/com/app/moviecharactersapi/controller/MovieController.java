package com.app.moviecharactersapi.controller;

import com.app.moviecharactersapi.dto.IntegerListRequest;
import com.app.moviecharactersapi.dto.movie.GetMovieDto;
import com.app.moviecharactersapi.dto.movie.MovieCharactersDto;
import com.app.moviecharactersapi.dto.movie.PostMovieDto;
import com.app.moviecharactersapi.mapper.MapStructMapper;
import com.app.moviecharactersapi.model.Movie;
import com.app.moviecharactersapi.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<GetMovieDto> getAllMovies() {
        return MapStructMapper.MAPPER.getAllMoviesDto(movieService.getAllMovies());
    }

    @PostMapping
    public Movie createMovie(@RequestBody PostMovieDto postMovieDto) {
        return movieService.createMovie(MapStructMapper.MAPPER.moviePostDtoToMovie(postMovieDto));
    }

    @GetMapping("/{id}")
    public GetMovieDto getMovieById(@PathVariable Integer id) {
        return MapStructMapper.MAPPER.movieToMovieGetDto(movieService.getMovieById(id));
    }

    @PutMapping("/{id}")
    public GetMovieDto updateMovie(@PathVariable Integer id, @RequestBody PostMovieDto movie) {
        return MapStructMapper.MAPPER.movieToMovieGetDto(movieService.updateMovie(id, movie));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Integer id) {
        return movieService.deleteMovie(id);
    }


    /**
     * Updating characters in a movie.
     * This can take in an integer array of character Id’s in the body, and a Movie Id in the path.
     *
     * @param movieId
     * @param charactersIdList
     * @return
     */
    @PutMapping("/addCharacters/{movieId}")
    public ResponseEntity<?> addCharactersInMovie(@PathVariable(name = "movieId") Integer movieId, @RequestBody IntegerListRequest charactersIdList) {
        return movieService.updateCharactersInMovie(movieId, charactersIdList.getIntegers());
    }


    /**
     * Get all the characters in a movie.
     *
     * @param movieId
     * @return
     */
    @GetMapping("/getAllCharacters/{movieId}")
    public List<MovieCharactersDto> getAllCharactersInAMovie(@PathVariable Integer movieId) {
        return MapStructMapper.MAPPER.getAllMovieCharacters(movieService.getAllCharactersOfMovie(movieId));
    }


}
