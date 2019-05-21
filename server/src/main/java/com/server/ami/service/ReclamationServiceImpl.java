package com.server.ami.service;

import com.server.ami.dao.*;
import com.server.ami.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReclamationServiceImpl implements ReclamationService {


    @Autowired
    private ReclamationDao reclamationDao = new ReclamationDaoImpl();


    @Override
    public boolean ajouter(Reclamation reclamation) {
        return reclamationDao.ajouter(reclamation);
    }

    @Override
    public boolean supprimer(String id) {
        return reclamationDao.supprimer(this.reclamation(id));
    }

    @Override
            public boolean modifier(Reclamation reclamation) {
        return reclamationDao.modifier(reclamation);
    }

    @Override
    public List<Reclamation> list() {
        return reclamationDao.list();
    }

    @Override
    public Reclamation reclamation(String id) {
        return reclamationDao.reclamation(id);
    }
}
