package com.server.ami.dao;

import com.server.ami.entity.*;

import java.util.*;

public interface ActualiteDao {

    public boolean ajouter(Actualite actualite);
    public boolean supprimer(Actualite actualite);
    public boolean modifier(Actualite actualite);
    public List<Actualite> list();
    public Actualite actualite(String id);

}
