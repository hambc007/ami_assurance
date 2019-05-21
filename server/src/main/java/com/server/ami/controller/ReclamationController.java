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
@RequestMapping({"api/reclamation"})
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ReclamationController {


    @Autowired
    private ReclamationService reclamationService;


    @GetMapping("/{id}")
    public ResponseEntity<Reclamation> getById(@PathVariable("id") String id) {
        Reclamation reclamation = reclamationService.reclamation(id);
        return new ResponseEntity<Reclamation>(reclamation, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Reclamation>> getAll() {
        List<Reclamation> list = reclamationService.list();
        return new ResponseEntity<List<Reclamation>>(list, HttpStatus.OK);
    }



    @PostMapping("/ajouter")
    public ResponseEntity<Reclamation> addReclamation(@RequestBody Reclamation reclamation, UriComponentsBuilder builder) {
        reclamationService.ajouter(reclamation);
        return new ResponseEntity<Reclamation>(reclamation, HttpStatus.CREATED);
    }


    @PutMapping("/modifier")
    public ResponseEntity<Reclamation> updateReclamation(@RequestBody String id) {

        Reclamation reclamationData = reclamationService.reclamation(id);
        if (reclamationData != null) {


            reclamationData.setTraiter(1);

            return new ResponseEntity(reclamationService.ajouter(reclamationData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deleteReclamation(@PathVariable("id") String id) {
        reclamationService.supprimer(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
