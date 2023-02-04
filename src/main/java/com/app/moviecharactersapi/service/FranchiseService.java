package com.app.moviecharactersapi.service;

import com.app.moviecharactersapi.dto.franchise.PostFranchiseDto;
import com.app.moviecharactersapi.model.Character;
import com.app.moviecharactersapi.model.Franchise;
import com.app.moviecharactersapi.model.Movie;
import com.app.moviecharactersapi.repository.FranchiseRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FranchiseService {
    private final FranchiseRepository franchiseRepository;
    private final MovieService movieService;

    public FranchiseService(FranchiseRepository franchiseRepository, MovieService movieService) {
        this.franchiseRepository = franchiseRepository;
        this.movieService = movieService;
    }

    public List<Franchise> getAllFranchises() {
        return franchiseRepository.findAll();
    }

    public Franchise createFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    public Franchise getFranchiseById(Integer id) {
        return franchiseRepository.getById(id);
    }

    public Franchise updateFranchise(Integer id, PostFranchiseDto franchise) {
        Franchise existingFranchise = getFranchiseById(id);
        if (existingFranchise != null) {
            existingFranchise.setName(franchise.getName());
            existingFranchise.setDescription(franchise.getDescription());
            franchiseRepository.save(existingFranchise);
        }
        return existingFranchise;
    }

    @Transactional
    public ResponseEntity<?> deleteFranchise(Integer id) {
        Franchise franchiseToDelete = getFranchiseById(id);
        if (franchiseToDelete != null) {
            franchiseToDelete.setMovies(null);
            Franchise updatedFranchise = franchiseRepository.save(franchiseToDelete);
            franchiseRepository.delete(updatedFranchise);
            return new ResponseEntity<>("Franchise has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There is no franchise against this ID", HttpStatus.BAD_REQUEST);
        }
    }

    @Transactional
    public Franchise updateMoviesInFranchise(Integer franchiseId, List<Integer> moviesIdList) {
        Franchise franchise = getFranchiseById(franchiseId);
        if (franchise != null) {
            for (Integer movieId : moviesIdList
            ) {
                Movie movie = movieService.getMovieById(movieId);
                if (movie != null && !franchise.getMovies().contains(movie)) {
                    franchise.getMovies().add(movie);
                }
            }
            return franchiseRepository.save(franchise);
        } else {
            throw new RuntimeException("There is no franchise with this ID: " + franchiseId);
        }
    }

    public List<Movie> getAllMoviesOfAFranchise(Integer franchiseId) {
        Franchise result = getFranchiseById(franchiseId);
        if (result != null) {
            return result.getMovies();
        } else {
            throw new RuntimeException("There is no franchise against this ID");
        }
    }

    public List<Character> getAllCharactersOfAFranchise(Integer franchiseId) {
        Map<Integer, Character> characterHashMap = new HashMap<>();
        Franchise result = getFranchiseById(franchiseId);
        if (result != null) {
            log.info("Result: {}", result.toString());
            for (Movie movie : result.getMovies()
            ) {
                log.info("Movie: {}", movie);
                for (Character character : movie.getCharacters()
                ) {
                    log.info("Character: {}", character);
                    characterHashMap.put(character.getId(), character);
                }
            }

            List<Character> characterArrayList = new ArrayList<>();
            log.info("Character hashmap values: {}", characterHashMap);

            for (Map.Entry<Integer, Character> entry : characterHashMap.entrySet()) {
                System.out.println("Key = " + entry.getKey() +
                        ", Value = " + entry.getValue());
                characterArrayList.add(entry.getValue());

            }
            return characterArrayList;
        } else {
            throw new RuntimeException("There is no franchise against this ID");
        }
    }
}
