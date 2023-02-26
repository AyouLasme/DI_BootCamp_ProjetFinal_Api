package com.api.taylor.controllers;

import com.api.taylor.models.TCustomers;
import com.api.taylor.repository.RCustomers;
import com.api.taylor.repository.RTaylors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/customers")
public class CCustomers {
    @Autowired
    private RCustomers rCostomers;

    @GetMapping()
    public List<TCustomers> findAll() {
        return (List<TCustomers>) rCostomers.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TCustomers> findById(@PathVariable(value = "id") long id) {
        Optional<TCustomers> tCustomers = rCostomers.findById(id);

        if(tCustomers.isPresent()) {
            return ResponseEntity.ok().body(tCustomers.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public TCustomers save(@Validated @RequestBody TCustomers customers) {
        return rCostomers.save(customers);
    }


    @DeleteMapping()
    public ResponseEntity<TCustomers> update(@Validated @RequestBody TCustomers customers){
        return new ResponseEntity<>(rCostomers.save(customers), HttpStatus.CREATED);
    }

    @PutMapping()
    public void delete(@Validated @RequestBody TCustomers customers){
        rCostomers.deleteById(customers.getId());
    }
}
