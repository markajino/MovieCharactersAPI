package com.app.moviecharactersapi.mapper;

import com.app.moviecharactersapi.dto.character.GetCharacterDto;
import com.app.moviecharactersapi.dto.character.PostCharacterDto;
import com.app.moviecharactersapi.dto.franchise.GetFranchiseDto;
import com.app.moviecharactersapi.dto.franchise.PostFranchiseDto;
import com.app.moviecharactersapi.dto.movie.GetMovieDto;
import com.app.moviecharactersapi.dto.movie.MovieCharactersDto;
import com.app.moviecharactersapi.dto.movie.PostMovieDto;
import com.app.moviecharactersapi.model.Character;
import com.app.moviecharactersapi.model.Franchise;
import com.app.moviecharactersapi.model.Movie;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MapStructMapper {

    MapStructMapper MAPPER = Mappers.getMapper(MapStructMapper.class);


    //-----------Characters Mapstruct------------//

    GetCharacterDto characterToCharacterGetDto(Character character);

    Character characterPostDtoToCharacter(PostCharacterDto postCharacterDto);

    List<GetCharacterDto> getAllCharactersDto(List<Character> characters);

    //---------------Movies Mapstruct------//
    Movie moviePostDtoToMovie(PostMovieDto postMovieDto);

    GetMovieDto movieToMovieGetDto(Movie movie);

    List<GetMovieDto> getAllMoviesDto(List<Movie> movie);

    List<MovieCharactersDto> getAllMovieCharacters(List<Character> characters);

    //----------------Franchise Mapstruct------//
    List<GetFranchiseDto> getAllFranchises(List<Franchise> franchises);

    Franchise franchisePostDtoToFranchise(PostFranchiseDto characterPostDto);

    GetFranchiseDto franchiseToFranchiseGetDto(Franchise character);
}