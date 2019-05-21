package com.server.ami.service;

import com.server.ami.entity.*;

import java.util.*;

public interface ActualiteService {

    public boolean ajouter(Actualite actualite);
    public boolean supprimer(String id);
    public boolean modifier(Actualite actualite);
    public List<Actualite> list();
    public Actualite actualite(String id);

}
