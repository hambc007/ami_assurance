package com.server.ami.dao;

import com.server.ami.entity.*;

import java.util.List;

public interface ResultatDao {

    public boolean ajouter(Resultat resultat);
    public boolean supprimer(Resultat resultat);
    public boolean modifier(Resultat resultat);
    public List<Resultat> list();
    public Resultat resultat(String id);

}
