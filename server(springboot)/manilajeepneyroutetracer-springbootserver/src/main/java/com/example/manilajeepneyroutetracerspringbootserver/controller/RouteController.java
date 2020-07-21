package com.example.manilajeepneyroutetracerspringbootserver.controller;

import com.example.manilajeepneyroutetracerspringbootserver.exception.ResourceNotFoundException;
import com.example.manilajeepneyroutetracerspringbootserver.model.Route;
import com.example.manilajeepneyroutetracerspringbootserver.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
        return this.routeRepository.findRouteByName(routename)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with name: " + routename));
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public Route addRoute(@RequestBody Route route){
        return this.routeRepository.save(route);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(path = "{name}")
    public Route updateRouteByName(@RequestBody Route route, @PathVariable("name") String routename) {
        Route existingRoute = this.routeRepository.findRouteByName(routename)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with name: " + routename));
        existingRoute.setRoutename(route.getRoutename());
        existingRoute.setNumberofwaypointsadded(route.getNumberofwaypointsadded());
        existingRoute.setWaypointlat(route.getwaypointlat());
        existingRoute.setWaypointlng(route.getwaypointlng());
        return this.routeRepository.save(existingRoute);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(path = "{name}")
    public ResponseEntity<Route> deleteRouteByName(@PathVariable("name") String routename){
        Route existingRoute = this.routeRepository.findRouteByName(routename)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with name: " + routename));
        this.routeRepository.delete(existingRoute);
        return ResponseEntity.ok().build();
    }
}
