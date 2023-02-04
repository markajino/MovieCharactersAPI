package com.app.moviecharactersapi.mapper;

import com.app.moviecharactersapi.dto.character.GetCharacterDto;
import com.app.moviecharactersapi.dto.character.MoviesCharactersIdDto;
import com.app.moviecharactersapi.dto.character.PostCharacterDto;
import com.app.moviecharactersapi.dto.franchise.GetFranchiseDto;
import com.app.moviecharactersapi.dto.franchise.PostFranchiseDto;
import com.app.moviecharactersapi.dto.movie.GetMovieDto;
import com.app.moviecharactersapi.dto.movie.MovieCharactersDto;
import com.app.moviecharactersapi.dto.movie.PostMovieDto;
import com.app.moviecharactersapi.model.Character;
import com.app.moviecharactersapi.model.Franchise;
import com.app.moviecharactersapi.model.Movie;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-04T10:57:09+0200",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 19.0.1 (Oracle Corporation)"
)
public class MapStructMapperImpl implements MapStructMapper {

    @Override
    public GetCharacterDto characterToCharacterGetDto(Character character) {
        if ( character == null ) {
            return null;
        }

        GetCharacterDto getCharacterDto = new GetCharacterDto();

        getCharacterDto.setFullName( character.getFullName() );
        getCharacterDto.setAlias( character.getAlias() );
        getCharacterDto.setGender( character.getGender() );
        getCharacterDto.setPicture( character.getPicture() );
        getCharacterDto.setMovies( movieListToMoviesCharactersIdDtoList( character.getMovies() ) );

        return getCharacterDto;
    }

    @Override
    public Character characterPostDtoToCharacter(PostCharacterDto postCharacterDto) {
        if ( postCharacterDto == null ) {
            return null;
        }

        Character.CharacterBuilder character = Character.builder();

        character.fullName( postCharacterDto.getFullName() );
        character.alias( postCharacterDto.getAlias() );
        character.gender( postCharacterDto.getGender() );
        character.picture( postCharacterDto.getPicture() );

        return character.build();
    }

    @Override
    public List<GetCharacterDto> getAllCharactersDto(List<Character> characters) {
        if ( characters == null ) {
            return null;
        }

        List<GetCharacterDto> list = new ArrayList<GetCharacterDto>( characters.size() );
        for ( Character character : characters ) {
            list.add( characterToCharacterGetDto( character ) );
        }

        return list;
    }

    @Override
    public Movie moviePostDtoToMovie(PostMovieDto postMovieDto) {
        if ( postMovieDto == null ) {
            return null;
        }

        Movie.MovieBuilder movie = Movie.builder();

        movie.movieTitle( postMovieDto.getMovieTitle() );
        movie.genre( postMovieDto.getGenre() );
        movie.releaseYear( postMovieDto.getReleaseYear() );
        movie.director( postMovieDto.getDirector() );
        movie.picture( postMovieDto.getPicture() );
        movie.trailer( postMovieDto.getTrailer() );

        return movie.build();
    }

    @Override
    public GetMovieDto movieToMovieGetDto(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        GetMovieDto getMovieDto = new GetMovieDto();

        getMovieDto.setMovieTitle( movie.getMovieTitle() );
        getMovieDto.setGenre( movie.getGenre() );
        getMovieDto.setReleaseYear( movie.getReleaseYear() );
        getMovieDto.setDirector( movie.getDirector() );
        getMovieDto.setPicture( movie.getPicture() );
        getMovieDto.setTrailer( movie.getTrailer() );

        return getMovieDto;
    }

    @Override
    public List<GetMovieDto> getAllMoviesDto(List<Movie> movie) {
        if ( movie == null ) {
            return null;
        }

        List<GetMovieDto> list = new ArrayList<GetMovieDto>( movie.size() );
        for ( Movie movie1 : movie ) {
            list.add( movieToMovieGetDto( movie1 ) );
        }

        return list;
    }

    @Override
    public List<MovieCharactersDto> getAllMovieCharacters(List<Character> characters) {
        if ( characters == null ) {
            return null;
        }

        List<MovieCharactersDto> list = new ArrayList<MovieCharactersDto>( characters.size() );
        for ( Character character : characters ) {
            list.add( characterToMovieCharactersDto( character ) );
        }

        return list;
    }

    @Override
    public List<GetFranchiseDto> getAllFranchises(List<Franchise> franchises) {
        if ( franchises == null ) {
            return null;
        }

        List<GetFranchiseDto> list = new ArrayList<GetFranchiseDto>( franchises.size() );
        for ( Franchise franchise : franchises ) {
            list.add( franchiseToFranchiseGetDto( franchise ) );
        }

        return list;
    }

    @Override
    public Franchise franchisePostDtoToFranchise(PostFranchiseDto characterPostDto) {
        if ( characterPostDto == null ) {
            return null;
        }

        Franchise.FranchiseBuilder franchise = Franchise.builder();

        franchise.name( characterPostDto.getName() );
        franchise.description( characterPostDto.getDescription() );

        return franchise.build();
    }

    @Override
    public GetFranchiseDto franchiseToFranchiseGetDto(Franchise character) {
        if ( character == null ) {
            return null;
        }

        GetFranchiseDto getFranchiseDto = new GetFranchiseDto();

        getFranchiseDto.setName( character.getName() );
        getFranchiseDto.setDescription( character.getDescription() );
        getFranchiseDto.setMovies( movieListToMoviesCharactersIdDtoList( character.getMovies() ) );

        return getFranchiseDto;
    }

    protected MoviesCharactersIdDto movieToMoviesCharactersIdDto(Movie movie) {
        if ( movie == null ) {
            return null;
        }

        MoviesCharactersIdDto moviesCharactersIdDto = new MoviesCharactersIdDto();

        moviesCharactersIdDto.setId( movie.getId() );

        return moviesCharactersIdDto;
    }

    protected List<MoviesCharactersIdDto> movieListToMoviesCharactersIdDtoList(List<Movie> list) {
        if ( list == null ) {
            return null;
        }

        List<MoviesCharactersIdDto> list1 = new ArrayList<MoviesCharactersIdDto>( list.size() );
        for ( Movie movie : list ) {
            list1.add( movieToMoviesCharactersIdDto( movie ) );
        }

        return list1;
    }

    protected MovieCharactersDto characterToMovieCharactersDto(Character character) {
        if ( character == null ) {
            return null;
        }

        MovieCharactersDto movieCharactersDto = new MovieCharactersDto();

        movieCharactersDto.setFullName( character.getFullName() );
        movieCharactersDto.setAlias( character.getAlias() );
        movieCharactersDto.setGender( character.getGender() );
        movieCharactersDto.setPicture( character.getPicture() );

        return movieCharactersDto;
    }
}
