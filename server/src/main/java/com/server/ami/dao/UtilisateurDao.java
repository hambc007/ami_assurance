package com.server.ami.dao;

import com.server.ami.entity.*;
import java.util.*;

public interface UtilisateurDao {

    public boolean ajouter(Utilisateur utilisateur);
    public boolean supprimer(Utilisateur utilisateur);
    public boolean modifier(Utilisateur utilisateur);
    public List<Utilisateur> list();
    public Utilisateur utilisateur(String id);
    public Utilisateur login(String email,String password);
    public Utilisateur utilisateurEmail(String email);

}
