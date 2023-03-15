package com.api.taylor.controllers;

import com.api.taylor.models.*;
import com.api.taylor.repository.RDemandes;
import com.api.taylor.repository.RImages;
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
    private RImages rImages;

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
    public String save(@Validated @RequestBody TDemandes demandes) {
        //return rDemandes.save(demandes);
        try {
            rDemandes.save(demandes);
            return "ok";
        }
        catch (Exception e){
            return e.getMessage();
        }
//        System.out.println(demandes);
//        TMunicipality municipality = new TMunicipality();
//        municipality.setId(demandes.getMunicipality_id());
//        Optional<TUsers> sender = rUsers.findById(demandes.getSender_id());
//        TDemandes tDemandes=null;
//        if(sender.isPresent()){
//         tDemandes = TDemandes.builder()
//                .dateDmd(demandes.getDateDmd())
//                .dateRetrait(demandes.getDateRetrait())
//                .content(demandes.getContent())
//                .municipality(municipality)
//                .sender(sender.get())
//                .object(demandes.getObject())
//                .category(demandes.getCategory())
//                .build();
//        }
//            System.out.println(tDemandes);
//
//
//        rDemandes.save(tDemandes);
//
//        for (String image:demandes.getImageModele()) {
//            TImages tImages = new TImages();
//            tImages.setDemande(tDemandes);
//            tImages.setLink(image);
//            rImages.save(tImages);
//        }
//
//        return tDemandes;
    }


    @PutMapping()
    public ResponseEntity<TDemandes> update(@Validated @RequestBody TDemandes demandes){
        return new ResponseEntity<>(rDemandes.save(demandes), HttpStatus.CREATED);
    }

    @DeleteMapping()
    public void delete(@Validated @RequestBody TDemandes demandes){
        rDemandes.deleteById(demandes.getId());
    }
}
