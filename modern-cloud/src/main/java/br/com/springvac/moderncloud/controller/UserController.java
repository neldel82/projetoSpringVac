package br.com.springvac.moderncloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springvac.moderncloud.model.User;
import br.com.springvac.moderncloud.repository.UserRepo;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepo repo;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User userFinded = repo.findByEmailOrRacf(user.getEmail(), user.getRacf());

        if (userFinded != null) {
            if(userFinded.getSenha().equals(user.getSenha())) {
                return ResponseEntity.ok(userFinded);
            }
        }
        return ResponseEntity.status(401).build();
    }
}