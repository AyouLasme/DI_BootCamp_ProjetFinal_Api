package com.api.taylor.controllers;

import com.api.taylor.models.TTown;
import com.api.taylor.repository.RTown;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/town")
public class CTown{

    @Autowired
    private RTown rTown;

    @GetMapping()
    public List<TTown> findAll() {
        return (List<TTown>) rTown.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TTown> findById(@PathVariable(value = "id") long id) {
        Optional<TTown> town = rTown.findById(id);

        if(town.isPresent()) {
            return ResponseEntity.ok().body(town.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public TTown save(@Validated @RequestBody TTown town) {
        return rTown.save(town);
    }


    @DeleteMapping()
    public ResponseEntity<TTown> update(@Validated @RequestBody TTown town){
        return new ResponseEntity<>(rTown.save(town), HttpStatus.CREATED);
    }

    @PutMapping()
    public void delete(@Validated @RequestBody TTown town){
        rTown.deleteById(town.getId());
    }
}
