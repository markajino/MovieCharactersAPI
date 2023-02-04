package com.app.moviecharactersapi.service;

import com.app.moviecharactersapi.dto.character.PostCharacterDto;
import com.app.moviecharactersapi.model.Character;
import com.app.moviecharactersapi.repository.CharacterRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CharacterService {

    private final CharacterRepository characterRepository;

    public CharacterService(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }

    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @Transactional
    public Character createCharacter(Character character) {
        return characterRepository.save(character);
    }

    public Character getCharacterById(Integer id) {
        Optional<Character> result = characterRepository.findById(id);
        return result.orElse(null);
    }

    @Transactional
    public Character updateCharacter(Integer id, PostCharacterDto updatedCharacter) {
        Character existingCharacter = getCharacterById(id);
        if (existingCharacter != null) {
            existingCharacter.setGender(updatedCharacter.getGender());
            existingCharacter.setAlias(updatedCharacter.getAlias());
            existingCharacter.setFullName(updatedCharacter.getFullName());
            existingCharacter.setPicture(updatedCharacter.getPicture());
            return characterRepository.save(existingCharacter);
        } else {
            throw new RuntimeException("There is no character against this ID");
        }
    }

    @Transactional
    public ResponseEntity<?> deleteCharacter(Integer id) {
        Character characterToDelete = getCharacterById(id);

        if (characterToDelete != null) {
            characterToDelete.setMovies(null);
            Character updatedCharacter = characterRepository.save(characterToDelete);
            characterRepository.delete(updatedCharacter);
            return new ResponseEntity<>("Character has been deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("There is no Character against this ID", HttpStatus.BAD_REQUEST);
        }
    }
}
