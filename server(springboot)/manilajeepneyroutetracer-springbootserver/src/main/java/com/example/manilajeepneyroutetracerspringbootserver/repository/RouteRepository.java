package com.example.manilajeepneyroutetracerspringbootserver.repository;

import com.example.manilajeepneyroutetracerspringbootserver.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {
    @Query("SELECT r from Route r where r.routename = ?1")
    Optional<Route> findRouteByName(String routename);
}
