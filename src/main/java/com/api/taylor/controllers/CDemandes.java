package com.api.taylor.controllers;

import com.api.taylor.models.*;
import com.api.taylor.repository.RCustomers;
import com.api.taylor.repository.RDemandes;
import com.api.taylor.repository.RUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/demandes")
public class CDemandes {

    @Autowired
    private RDemandes rDemandes;

    @Autowired
    private RUsers rUsers;


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


    @PutMapping()
    public ResponseEntity<?> update(@Validated @RequestBody TDemandes demandes){
        Optional<TDemandes> check = rDemandes.findById(demandes.getId());
        if(check.isEmpty()){
            return new ResponseEntity<>("Current demande not found", HttpStatus.NOT_FOUND);
        }else{
            check.get().setContent(demandes.getContent());
            check.get().setCategory(demandes.getCategory());
            check.get().setImages(demandes.getImages());
            check.get().setObject(demandes.getObject());
            check.get().setMunicipality(demandes.getMunicipality());
            check.get().setContent(demandes.getContent());
            check.get().setDateDmd(demandes.getDateDmd());
            check.get().setDateRetrait(demandes.getDateRetrait());
            rDemandes.save(check.get());

            return new ResponseEntity<>("Data is updated", HttpStatus.OK);
        }
    }

    @DeleteMapping()
    public String delete(@Validated @RequestBody TDemandes demandes){
        rDemandes.deleteById(demandes.getId());
        return "Ok" ;
    }
}
