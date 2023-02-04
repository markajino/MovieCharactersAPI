package com.app.moviecharactersapi.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieCharactersDto {
    private String fullName;
    private String alias;
    private String gender;
    private String picture;
}
