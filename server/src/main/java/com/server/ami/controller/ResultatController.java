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
@RequestMapping({"api/resultat"})
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ResultatController {


    @Autowired
    private ResultatService resultatService;


    @GetMapping("/{id}")
    public ResponseEntity<Resultat> getById(@PathVariable("id") String id) {
        Resultat resultat = resultatService.resultat(id);
        return new ResponseEntity<Resultat>(resultat, HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<Resultat>> getAll() {
        List<Resultat> list = resultatService.list();
        return new ResponseEntity<List<Resultat>>(list, HttpStatus.OK);
    }


    @PostMapping("/ajouter")
    public ResponseEntity<Resultat> addResultat(@RequestBody Resultat resultat, UriComponentsBuilder builder) {
        resultatService.ajouter(resultat);
        return new ResponseEntity<Resultat>(resultat, HttpStatus.CREATED);
    }


    @PutMapping("/modifier")
    public ResponseEntity<Resultat> updateResultat(@RequestBody Resultat resultat) {


        return null;
    }


    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deleteResultat(@PathVariable("id") String id) {
        resultatService.supprimer(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
