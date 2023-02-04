package com.app.moviecharactersapi.controller;


import com.app.moviecharactersapi.dto.character.GetCharacterDto;
import com.app.moviecharactersapi.dto.character.PostCharacterDto;
import com.app.moviecharactersapi.mapper.MapStructMapper;
import com.app.moviecharactersapi.service.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/characters")
public class CharacterController {

    private final CharacterService characterService;


    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<GetCharacterDto> getAllCharacters() {
        return MapStructMapper.MAPPER.getAllCharactersDto(characterService.getAllCharacters());
    }

    @PostMapping
    public GetCharacterDto createCharacter(@RequestBody PostCharacterDto postCharacterDto) {
        return MapStructMapper.MAPPER.characterToCharacterGetDto(
                characterService.createCharacter(
                        MapStructMapper.MAPPER.characterPostDtoToCharacter(postCharacterDto)
                )
        );
    }

    @GetMapping("/{id}")
    public GetCharacterDto getCharacterById(@PathVariable Integer id) {
        return MapStructMapper.MAPPER.characterToCharacterGetDto(characterService.getCharacterById(id));
    }

    @PutMapping("/{id}")
    public GetCharacterDto updateCharacter(@PathVariable Integer id, @RequestBody PostCharacterDto postCharacterDto) {
        return MapStructMapper.MAPPER.characterToCharacterGetDto(characterService.updateCharacter(id, postCharacterDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCharacter(@PathVariable Integer id) {
       return characterService.deleteCharacter(id);
    }
}

