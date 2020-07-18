package com.example.manilajeepneyroutetracerspringbootserver.controller;

import com.example.manilajeepneyroutetracerspringbootserver.model.Route;
import com.example.manilajeepneyroutetracerspringbootserver.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/routes")
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Route> getAllUsers(){
        return this.routeRepository.findAll();
    }
}
