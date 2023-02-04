package com.app.moviecharactersapi.dto.character;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetCharacterDto {
    private String fullName;
    private String alias;
    private String gender;
    private String picture;
    private List<MoviesCharactersIdDto> movies;

}
