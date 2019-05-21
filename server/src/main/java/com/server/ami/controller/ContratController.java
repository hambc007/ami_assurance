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
@RequestMapping({"api/contrat"})
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ContratController {


    @Autowired
    private ContratService contratService;


    @GetMapping("/{id}")
    public ResponseEntity<Contrat> getById(@PathVariable("id") String id) {
        Contrat contrat = contratService.contrat(id);
        return new ResponseEntity<Contrat>(contrat, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Contrat>> getAll() {
        List<Contrat> list = contratService.list();
        return new ResponseEntity<List<Contrat>>(list, HttpStatus.OK);
    }



    @PostMapping("/ajouter")
    public ResponseEntity<Contrat> addContrat(@RequestBody Contrat contrat, UriComponentsBuilder builder) {
        contratService.ajouter(contrat);
        return new ResponseEntity<Contrat>(contrat, HttpStatus.CREATED);
    }


    @PutMapping("/modifier")
    public ResponseEntity<Contrat> updateContrat(@RequestBody Contrat contrat) {
        contratService.modifier(contrat);
        return new ResponseEntity<Contrat>(contrat, HttpStatus.OK);
    }


    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deleteContrat(@PathVariable("id") String id) {
        contratService.supprimer(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
