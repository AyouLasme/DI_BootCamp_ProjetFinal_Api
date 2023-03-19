package com.api.taylor.controllers;

import ch.qos.logback.core.model.Model;
import com.api.taylor.models.TDemandes;
import com.api.taylor.models.TMessages;
import com.api.taylor.models.TReponse;
import com.api.taylor.repository.RDemandes;
import com.api.taylor.repository.RMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/messages")
public class CMessages {

    @Autowired
    private RMessages rMessages;

    @GetMapping()
    public List<TMessages> findAll() {
        return (List<TMessages>) rMessages.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<TMessages> findById(@PathVariable(value = "id") long id) {
        Optional<TMessages> messages = rMessages.findById(id);

        if(messages.isPresent()) {
            return ResponseEntity.ok().body(messages.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/{demande_id}/{sender_id}")
//    public List<TMessages> findBySenderDemande(@PathVariable(value = "demande_id") long demande_fk, @PathVariable(value = "sender_id") long sender_fk) {
//        return (List<TMessages>) rMessages.findBySenderDemande(demande_fk, sender_fk);
//    }

//    @GetMapping("/")
//    public String index(Model model) {
//        List<TMessages> messages = rMessages.findAllByOrderByTimestampDesc();
//        if (!messages.isEmpty()) {
//            model.addAttribute("lastMessage", messages.get(0));
//        }
//        return "index";
//    }
//
//    @PostMapping("/messages")
//    public String postMessage(@RequestParam("content") String content) {
//        TMessages message = new TMessages();
//        message.setContent(content);
//        message.setDateMsg(new Date());
//        rMessages.save(message);
//        return "redirect:/";
//    }

    @PostMapping()
    public TMessages save(@Validated @RequestBody TMessages messages) {
        return rMessages.save(messages);
    }


    @PutMapping()
    public ResponseEntity<TMessages> update(@Validated @RequestBody TMessages messages){
        return new ResponseEntity<>(rMessages.save(messages), HttpStatus.CREATED);
    }

    @DeleteMapping()
    public String delete(@Validated @RequestBody TMessages messages) {
        rMessages.deleteById(messages.getId());
        return  "Ok" ;
    }
}
