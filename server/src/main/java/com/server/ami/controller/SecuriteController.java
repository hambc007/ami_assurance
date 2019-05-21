package com.server.ami.controller;


import com.server.ami.config.JwtGenerator;
import com.server.ami.entity.Utilisateur;
import com.server.ami.service.UtilisateurService;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class SecuriteController {
    private JSONObject result = null;
    private JSONArray array = null;
    private String token = "false";

    @Autowired
    private UtilisateurService utilisateurService;
    @Autowired
    private JwtGenerator jwt;

    @PostMapping("/login")
    public String login(@RequestBody Utilisateur loginuser) throws JSONException {
        String jwtToken = "";

        Utilisateur utilisateur = utilisateurService.login(loginuser.getEmail(), loginuser.getPassword());
        if (utilisateur != null) {

            result = new JSONObject();
            array = new JSONArray();

            jwtToken = jwt.generate(utilisateur);
            array.put(jwtToken);
            JSONObject role = new JSONObject();
            role.put("id", utilisateur.getRole().getId());
            role.put("role", utilisateur.getRole().getRole());

            JSONObject jo = new JSONObject();
            jo.put("id", utilisateur.getId());
            jo.put("cin", utilisateur.getCin());
            jo.put("email", utilisateur.getEmail());
            jo.put("role", role);
            jo.put("image", utilisateur.getImage());
            jo.put("nom", utilisateur.getNom());
            jo.put("prenom", utilisateur.getPrenom());
            jo.put("telephone", utilisateur.getTelephone());
            jo.put("password", utilisateur.getPassword());
            jo.put("datenaissance", utilisateur.getDatenaissance());
            jo.put("adresse", utilisateur.getAdresse());
            array.put(jo);
            result.put("data", array);
            token = result.toString();
        } else {
            token = "false";
        }
        return token;
    }
}
