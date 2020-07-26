package com.example.manilajeepneyroutetracerspringbootserver.controller;

import com.example.manilajeepneyroutetracerspringbootserver.model.User;
import com.example.manilajeepneyroutetracerspringbootserver.repository.RouteRepository;
import com.example.manilajeepneyroutetracerspringbootserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping(path = "{username}/{password}")
    public boolean userExists(@PathVariable("username") String username, @PathVariable("password") String password){
        Optional<User> result = this.userRepository.userExistsOnDatabase(username, password);
        if(result.isPresent()){
            return true;
        }
        else {
            return false;
        }
    }
}
