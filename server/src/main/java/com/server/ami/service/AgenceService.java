package com.server.ami.service;

import com.server.ami.entity.*;

import java.util.List;

public interface AgenceService {

    public boolean ajouter(Agence agence);
    public boolean supprimer(String id);
    public boolean modifier(Agence agence);
    public List<Agence> list();
    public Agence agence(String id);

}
