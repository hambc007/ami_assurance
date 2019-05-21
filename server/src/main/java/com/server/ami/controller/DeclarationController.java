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
@RequestMapping({"api/declaration"})
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class DeclarationController {


    @Autowired
    private DeclarationService declarationService;


    @GetMapping("/{id}")
    public ResponseEntity<Declaration> getById(@PathVariable("id") String id) {
        Declaration declaration = declarationService.declaration(id);
        return new ResponseEntity<Declaration>(declaration, HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<Declaration>> getAll() {
        List<Declaration> list = declarationService.list();
        return new ResponseEntity<List<Declaration>>(list, HttpStatus.OK);
    }


    @PostMapping("/ajouter")
    public ResponseEntity<Declaration> addDeclaration(@RequestBody Declaration declaration, UriComponentsBuilder builder) {
        declarationService.ajouter(declaration);
        return new ResponseEntity<Declaration>(declaration, HttpStatus.CREATED);
    }


    @PutMapping("/modifier")
    public ResponseEntity<Declaration> updateDeclaration(@RequestBody String id) {

      Declaration declarationData = declarationService.declaration(id);
      if (declarationData != null) {

          declarationData.setTraiter(1);

          return new ResponseEntity(declarationService.ajouter(declarationData), HttpStatus.OK);
      } else {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
    }


    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deleteDeclaration(@PathVariable("id") String id) {
        declarationService.supprimer(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
