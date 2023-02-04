package com.app.moviecharactersapi.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 200)
    private String movieTitle;
    private String genre;
    private LocalDate releaseYear;
    @Column(length = 150)
    private String director;
    private String picture;
    private String trailer;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "movie_characters",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")})
    private List<Character> characters = new ArrayList<>();

    @ToString.Exclude
    @JoinColumn(name = "franchise_id")
    @OneToOne(fetch = FetchType.LAZY)
    private Franchise franchise;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", movieTitle='" + movieTitle + '\'' +
                ", genre='" + genre + '\'' +
                ", releaseYear=" + releaseYear +
                ", director='" + director + '\'' +
                ", picture='" + picture + '\'' +
                ", trailer='" + trailer + '\'' +
                '}';
    }
}
