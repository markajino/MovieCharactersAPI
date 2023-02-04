package com.app.moviecharactersapi.dto.franchise;

import com.app.moviecharactersapi.dto.character.MoviesCharactersIdDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetFranchiseDto {
    private String name;
    private String description;
    private List<MoviesCharactersIdDto> movies;
}
