package com.server.ami.service;

import com.server.ami.entity.*;

import java.util.List;

public interface ContratService {

    public boolean ajouter(Contrat contrat);
    public boolean supprimer(String id);
    public boolean modifier(Contrat contrat);
    public List<Contrat> list();
    public Contrat contrat(String id);

}
