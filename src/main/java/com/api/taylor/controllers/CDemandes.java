package com.api.taylor.controllers;

import com.api.taylor.models.TCustomers;
import com.api.taylor.models.TDemandes;
import com.api.taylor.repository.RCustomers;
import com.api.taylor.repository.RDemandes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/demandes")
public class CDemandes {

    @Autowired
    private RDemandes rDemandes;

    @GetMapping()
    public List<TDemandes> findAll() {
        return (List<TDemandes>) rDemandes.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TDemandes> findById(@PathVariable(value = "id") long id) {
        Optional<TDemandes> demandes = rDemandes.findById(id);

        if(demandes.isPresent()) {
            return ResponseEntity.ok().body(demandes.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public TDemandes save(@Validated @RequestBody TDemandes demandes) {
        return rDemandes.save(demandes);
    }


    @DeleteMapping()
    public ResponseEntity<TDemandes> update(@Validated @RequestBody TDemandes demandes){
        return new ResponseEntity<>(rDemandes.save(demandes), HttpStatus.CREATED);
    }

    @PutMapping()
    public void delete(@Validated @RequestBody TDemandes demandes){
        rDemandes.deleteById(demandes.getId());
    }
}
