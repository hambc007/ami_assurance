package com.server.ami.controller;

import com.server.ami.entity.*;
import com.server.ami.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping({"api/actualite"})
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ActualiteController {


    @Autowired
    private ActualiteService actualiteService;


    @GetMapping("/{id}")
    public ResponseEntity<Actualite> getById(@PathVariable("id") String id) {
        Actualite actualite = actualiteService.actualite(id);
        return new ResponseEntity<Actualite>(actualite, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Actualite>> getAll() {
        List<Actualite> list = actualiteService.list();
        return new ResponseEntity<List<Actualite>>(list, HttpStatus.OK);
    }



    @PostMapping("/ajouter")
    public ResponseEntity<Actualite> addActualite(@RequestBody Actualite actualite, UriComponentsBuilder builder) {
        actualiteService.ajouter(actualite);
        return new ResponseEntity<Actualite>(actualite, HttpStatus.CREATED);
    }


    @PutMapping("/modifier")
    public ResponseEntity<Actualite> updateActualite(@RequestBody Actualite actualite) {
        actualiteService.modifier(actualite);
        return new ResponseEntity<Actualite>(actualite, HttpStatus.OK);
    }


    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deleteActualite(@PathVariable("id") String id) {
        actualiteService.supprimer(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
