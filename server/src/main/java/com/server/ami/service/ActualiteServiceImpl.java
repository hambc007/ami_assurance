package com.server.ami.service;

import com.server.ami.dao.*;
import com.server.ami.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ActualiteServiceImpl implements ActualiteService {


    @Autowired
    private ActualiteDao actualiteDao = new ActualiteDaoImpl();


    @Override
    public boolean ajouter(Actualite actualite) {
        return actualiteDao.ajouter(actualite);
    }

    @Override
    public boolean supprimer(String id) {
        return actualiteDao.supprimer(this.actualite(id));
    }

    @Override
            public boolean modifier(Actualite actualite) {
        return actualiteDao.modifier(actualite);
    }

    @Override
    public List<Actualite> list() {
        return actualiteDao.list();
    }

    @Override
    public Actualite actualite(String id) {
        return actualiteDao.actualite(id);
    }
}
