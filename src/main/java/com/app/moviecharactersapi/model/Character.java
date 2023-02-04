package com.app.moviecharactersapi.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 150)
    private String fullName;
    @Column(length = 100)
    private String alias;
    @Column(length = 20)
    private String gender;
    private String picture;

    @ManyToMany(mappedBy = "characters")
    private List<Movie> movies;

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", alias='" + alias + '\'' +
                ", gender='" + gender + '\'' +
                ", picture='" + picture + '\'' +
                '}';
    }
}
