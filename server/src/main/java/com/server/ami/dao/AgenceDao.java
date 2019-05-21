package com.server.ami.dao;

import com.server.ami.entity.*;

import java.util.List;

public interface AgenceDao {

    public boolean ajouter(Agence agence);
    public boolean supprimer(Agence agence);
    public boolean modifier(Agence agence);
    public List<Agence> list();
    public Agence agence(String id);

}
