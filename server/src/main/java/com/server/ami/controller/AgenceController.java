package com.server.ami.controller;

import com.server.ami.entity.*;
import com.server.ami.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping({"api/agence"})
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AgenceController {


    @Autowired
    private AgenceService agenceService;


    @GetMapping("/{id}")
    public ResponseEntity<Agence> getById(@PathVariable("id") String id) {
        Agence agence = agenceService.agence(id);
        return new ResponseEntity<Agence>(agence, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Agence>> getAll() {
        List<Agence> list = agenceService.list();
        return new ResponseEntity<List<Agence>>(list, HttpStatus.OK);
    }



    @PostMapping("/ajouter")
    public ResponseEntity<Agence> addAgence(@RequestBody Agence agence, UriComponentsBuilder builder) {
        agenceService.ajouter(agence);
        return new ResponseEntity<Agence>(agence, HttpStatus.CREATED);
    }


    @PutMapping("/modifier")
    public ResponseEntity<Agence> updateAgence(@RequestBody Agence agence) {
        agenceService.modifier(agence);
        return new ResponseEntity<Agence>(agence, HttpStatus.OK);
    }


    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deleteAgence(@PathVariable("id") String id) {
        agenceService.supprimer(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
