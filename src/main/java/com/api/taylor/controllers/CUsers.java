package com.api.taylor.controllers;

import com.api.taylor.models.*;
import com.api.taylor.repository.RUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/users")
public class CUsers {

    @Autowired
    private RUsers rUsers;

    @GetMapping()
    public List<TUsers> findAll() {
        return (List<TUsers>) rUsers.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TUsers> findById(@PathVariable(value = "id") long id) {
        Optional<TUsers> users = rUsers.findById(id);

        if(users.isPresent()) {
            return ResponseEntity.ok().body(users.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("login")
    public ResponseEntity<TUsers> login(@RequestBody @Validated TLoginPayLoad loginPayLoad) {
        System.out.println(loginPayLoad);
        Optional<TUsers> users = rUsers.findByEmailAndPassword(loginPayLoad.getEmail(), loginPayLoad.getPassword());

        if(users.isPresent()) {
            return ResponseEntity.ok().body(users.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PostMapping("register")
    public ResponseEntity<TUsers> register(@RequestBody @Validated TRegisterPayLoad registerPayLoad) {
        System.out.println(registerPayLoad);
        TUsers user = new TUsers();
        user.setLastname(registerPayLoad.getLastname());
        user.setFirstname(registerPayLoad.getFirstname());
        user.setEmail(registerPayLoad.getEmail());
        user.setAdresse(registerPayLoad.getAdresse());
        user.setTel(registerPayLoad.getTel());
        user.setSexe(registerPayLoad.getSexe());
        user.setRole(registerPayLoad.getRole());
        user.setPassword(registerPayLoad.getPassword());

        rUsers.save(user);

        return ResponseEntity.ok().body(user);
    }



    @PostMapping()
    public String save(@Validated @RequestBody TUsers tUser) {
        try {
            rUsers.save(tUser);
            return "ok";
        }
        catch (Exception e){
            return e.getMessage();
        }
    }


    @DeleteMapping()
    public ResponseEntity<TUsers> update(@Validated @RequestBody TUsers users){
        return new ResponseEntity<>(rUsers.save(users), HttpStatus.CREATED);
    }

    @PutMapping()
    public void delete(@Validated @RequestBody TUsers users){
        rUsers.deleteById(users.getId());
    }
}
