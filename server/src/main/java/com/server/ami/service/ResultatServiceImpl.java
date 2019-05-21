package com.server.ami.service;

import com.server.ami.dao.*;
import com.server.ami.dao.*;
import com.server.ami.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ResultatServiceImpl implements ResultatService {


    @Autowired
    private ResultatDao resultatDao = new ResultatDaoImpl();


    @Override
    public boolean ajouter(Resultat resultat) {
        return resultatDao.ajouter(resultat);
    }

    @Override
    public boolean supprimer(String id) {
        return resultatDao.supprimer(this.resultat(id));
    }

    @Override
            public boolean modifier(Resultat resultat) {
        return resultatDao.modifier(resultat);
    }

    @Override
    public List<Resultat> list() {
        return resultatDao.list();
    }

    @Override
    public Resultat resultat(String id) {
        return resultatDao.resultat(id);
    }
}
