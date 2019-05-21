package com.server.ami.service;

import com.server.ami.entity.Utilisateur;

import java.util.List;

public interface UtilisateurService {

    public boolean ajouter(Utilisateur utilisateur);
    public boolean supprimer(String id);
    public boolean modifier(Utilisateur utilisateur);
    public List<Utilisateur> list();
    public Utilisateur utilisateur(String id);
    public Utilisateur login(String email,String password);
    public Utilisateur utilisateurEmail(String email);

}
