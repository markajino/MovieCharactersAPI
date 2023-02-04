package com.app.moviecharactersapi.repository;

import com.app.moviecharactersapi.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
}