package com.server.ami.controller;

import com.server.ami.entity.Utilisateur;
import com.server.ami.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping({"api/utilisateur"})
public class UtilisateurController {


    @Autowired
    private UtilisateurService utilisateurService;


    @GetMapping("/{id}")
    public ResponseEntity<Utilisateur> getById(@PathVariable("id") String id) {
        Utilisateur utilisateur = utilisateurService.utilisateur(id);
        return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<List<Utilisateur>> getAll() {
        List<Utilisateur> list = utilisateurService.list();
        return new ResponseEntity<List<Utilisateur>>(list, HttpStatus.OK);
    }



    @PostMapping("/ajouter")
    public ResponseEntity<Utilisateur> addUtilisateur(@RequestBody Utilisateur utilisateur, UriComponentsBuilder builder) {
        utilisateurService.ajouter(utilisateur);
        return new ResponseEntity<Utilisateur>(utilisateur, HttpStatus.CREATED);
    }


    @PutMapping("/modifier/{id}")
    public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable("id") String id,@RequestBody Utilisateur utilisateur) {

        Utilisateur utilisateurData = utilisateurService.utilisateur(id);
        if (utilisateurData != null) {


            utilisateurData.setId(utilisateur.getId());
            utilisateurData.setEmail(utilisateur.getEmail());
            utilisateurData.setPassword(utilisateur.getPassword());
            utilisateurData.setCin(utilisateur.getCin());
            utilisateurData.setImage(utilisateur.getImage());
            utilisateurData.setNom(utilisateur.getNom());
            utilisateurData.setPrenom(utilisateur.getPrenom());
            utilisateurData.setTelephone(utilisateur.getTelephone());
            utilisateurData.setDatenaissance(utilisateur.getDatenaissance());
            utilisateurData.setAdresse(utilisateur.getAdresse());


            return new ResponseEntity(utilisateurService.ajouter(utilisateurData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deleteUtilisateur(@PathVariable("id") String id) {
        utilisateurService.supprimer(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
