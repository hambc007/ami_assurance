package com.server.ami.service;

import com.server.ami.dao.*;
import com.server.ami.dao.*;
import com.server.ami.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContratServiceImpl implements ContratService {


    @Autowired
    private ContratDao contratDao = new ContratDaoImpl();


    @Override
    public boolean ajouter(Contrat contrat) {
        return contratDao.ajouter(contrat);
    }

    @Override
    public boolean supprimer(String id) {
        return contratDao.supprimer(this.contrat(id));
    }

    @Override
    public boolean modifier(Contrat contrat) {
        return contratDao.modifier(contrat);
    }

    @Override
    public List<Contrat> list() {
        return contratDao.list();
    }

    @Override
    public Contrat contrat(String id) {
        return contratDao.contrat(id);
    }
}
