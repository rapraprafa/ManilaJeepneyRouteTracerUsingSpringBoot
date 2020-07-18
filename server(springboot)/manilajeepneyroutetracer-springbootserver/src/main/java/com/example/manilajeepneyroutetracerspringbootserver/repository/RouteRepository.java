package com.example.manilajeepneyroutetracerspringbootserver.repository;

import com.example.manilajeepneyroutetracerspringbootserver.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Long> {

}
