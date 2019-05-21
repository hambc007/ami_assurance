package com.server.ami.dao;

import com.server.ami.entity.*;

import java.util.List;

public interface ContratDao {

    public boolean ajouter(Contrat contrat);
    public boolean supprimer(Contrat contrat);
    public boolean modifier(Contrat contrat);
    public List<Contrat> list();
    public Contrat contrat(String id);

}
