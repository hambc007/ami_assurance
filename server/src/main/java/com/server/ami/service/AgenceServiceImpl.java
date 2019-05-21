package com.server.ami.service;

import com.server.ami.dao.*;
import com.server.ami.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AgenceServiceImpl implements AgenceService {


    @Autowired
    private AgenceDao agenceDao = new AgenceDaoImpl();


    @Override
    public boolean ajouter(Agence agence) {
        return agenceDao.ajouter(agence);
    }

    @Override
    public boolean supprimer(String id) {
        return agenceDao.supprimer(this.agence(id));
    }

    @Override
    public boolean modifier(Agence agence) {
        return agenceDao.modifier(agence);
    }

    @Override
    public List<Agence> list() {
        return agenceDao.list();
    }

    @Override
    public Agence agence(String id) {
        return agenceDao.agence(id);
    }
}
