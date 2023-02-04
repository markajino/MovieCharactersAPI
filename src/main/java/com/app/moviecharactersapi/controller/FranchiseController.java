package com.app.moviecharactersapi.controller;

import com.app.moviecharactersapi.dto.IntegerListRequest;
import com.app.moviecharactersapi.dto.character.GetCharacterDto;
import com.app.moviecharactersapi.dto.franchise.GetFranchiseDto;
import com.app.moviecharactersapi.dto.franchise.PostFranchiseDto;
import com.app.moviecharactersapi.dto.movie.GetMovieDto;
import com.app.moviecharactersapi.mapper.MapStructMapper;
import com.app.moviecharactersapi.service.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/franchises")
public class FranchiseController {

    private final FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping
    public List<GetFranchiseDto> getAllFranchises() {
        return MapStructMapper.MAPPER.getAllFranchises(franchiseService.getAllFranchises());
    }

    @PostMapping
    public GetFranchiseDto createFranchise(@RequestBody PostFranchiseDto franchise) {
        return MapStructMapper.MAPPER.franchiseToFranchiseGetDto(franchiseService.createFranchise
                (MapStructMapper.MAPPER.franchisePostDtoToFranchise(franchise))
        );
    }

    @GetMapping("/{id}")
    public GetFranchiseDto getFranchiseById(@PathVariable Integer id) {
        return MapStructMapper.MAPPER.franchiseToFranchiseGetDto(franchiseService.getFranchiseById(id));

    }

    @PutMapping("/{id}")
    public GetFranchiseDto updateFranchise(@PathVariable Integer id, @RequestBody PostFranchiseDto franchise) {
        return MapStructMapper.MAPPER.franchiseToFranchiseGetDto(franchiseService.updateFranchise(id, franchise));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFranchise(@PathVariable Integer id) {
        return franchiseService.deleteFranchise(id);
    }


    //------------- Apart from CRUD APIs //

    /**
     * Updating movies in a franchise
     * This can take in an integer array of movie Id’s in the body, and a Franchise ID in the path.
     *
     * @param franchiseId
     * @param moviesList
     * @return
     */
    @PutMapping("/addMoviesInFranchise/{franchiseId}")
    public GetFranchiseDto updateMovieInFranchise(@PathVariable(name = "franchiseId") Integer franchiseId, @RequestBody IntegerListRequest moviesList) {
        return MapStructMapper.MAPPER.franchiseToFranchiseGetDto(franchiseService.updateMoviesInFranchise(franchiseId, moviesList.getIntegers()));
    }


    /**
     * Get all the movies in a franchise
     *
     * @param franchiseId
     * @return
     */
    @GetMapping("/getAllMoviesInAFranchise/{franchiseId}")
    public List<GetMovieDto> getAllMoviesInAFranchise(@PathVariable Integer franchiseId) {
        return MapStructMapper.MAPPER.getAllMoviesDto(franchiseService.getAllMoviesOfAFranchise(franchiseId));
    }

    @GetMapping("/getAllCharactersInAFranchise/{franchiseId}")
    public List<GetCharacterDto> getAllCharactersInAFranchise(@PathVariable Integer franchiseId) {
        return MapStructMapper.MAPPER.getAllCharactersDto(franchiseService.getAllCharactersOfAFranchise(franchiseId));
    }
}