package com.server.ami.dao;

import com.server.ami.entity.Reclamation;

import java.util.List;

public interface ReclamationDao {

    public boolean ajouter(Reclamation reclamation);
    public boolean supprimer(Reclamation reclamation);
    public boolean modifier(Reclamation reclamation);
    public List<Reclamation> list();
    public Reclamation reclamation(String id);

}
