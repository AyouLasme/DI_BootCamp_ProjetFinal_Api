package com.api.taylor.controllers;

import com.api.taylor.models.TUsers;
import com.api.taylor.repository.RUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @PostMapping()
    public TUsers save(@Validated @RequestBody TUsers tUser) {
        return rUsers.save(tUser);
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
