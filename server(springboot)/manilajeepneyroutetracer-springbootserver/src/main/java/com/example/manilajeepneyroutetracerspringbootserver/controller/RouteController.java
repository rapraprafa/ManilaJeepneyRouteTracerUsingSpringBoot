package com.example.manilajeepneyroutetracerspringbootserver.controller;

import com.example.manilajeepneyroutetracerspringbootserver.model.Route;
import com.example.manilajeepneyroutetracerspringbootserver.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/routes")
public class RouteController {

    @Autowired
    private RouteRepository routeRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<Route> getAllRoutes(){
        return this.routeRepository.findAll();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "{routename}")
    public Route getRouteByName(@PathVariable("routename") String routename){
        return this.routeRepository.findRouteByName(routename);
    }
}
