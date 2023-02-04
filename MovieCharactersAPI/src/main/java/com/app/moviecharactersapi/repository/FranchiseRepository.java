package com.app.moviecharactersapi.repository;

import com.app.moviecharactersapi.model.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
}
