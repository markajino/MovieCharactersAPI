package com.app.moviecharactersapi.dto.movie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetMovieDto {
    private String movieTitle;
    private String genre;
    private LocalDate releaseYear;
    private String director;
    private String picture;
    private String trailer;
}
