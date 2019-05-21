package com.server.ami.service;

import com.server.ami.entity.Actualite;
import com.server.ami.entity.Reclamation;

import java.util.List;

public interface ReclamationService {

    public boolean ajouter(Reclamation reclamation);
    public boolean supprimer(String id);
    public boolean modifier(Reclamation reclamation);
    public List<Reclamation> list();
    public Reclamation reclamation(String id);

}
