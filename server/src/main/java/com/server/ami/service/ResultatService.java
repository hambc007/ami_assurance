package com.server.ami.service;

import com.server.ami.entity.*;

import java.util.List;

public interface ResultatService {

    public boolean ajouter(Resultat resultat);
    public boolean supprimer(String id);
    public boolean modifier(Resultat resultat);
    public List<Resultat> list();
    public Resultat resultat(String id);

}
