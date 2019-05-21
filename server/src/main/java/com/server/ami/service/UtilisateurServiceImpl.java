package com.server.ami.service;

import com.server.ami.dao.*;
import com.server.ami.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UtilisateurServiceImpl implements UtilisateurService {


    @Autowired
    private UtilisateurDao utilisateurDao = new UtilisateurDaoImpl();


    @Override
    public boolean ajouter(Utilisateur utilisateur) {
        return utilisateurDao.ajouter(utilisateur);
    }

    @Override
    public boolean supprimer(String id) {
        return utilisateurDao.supprimer(this.utilisateur(id));
    }

    @Override
    public boolean modifier(Utilisateur utilisateur) {
        return utilisateurDao.modifier(utilisateur);
    }

    @Override
    public List<Utilisateur> list() {
        return utilisateurDao.list();
    }

    @Override
    public Utilisateur utilisateur(String id) {
        return utilisateurDao.utilisateur(id);
    }

    @Override
    public Utilisateur login(String email, String password) {

        return utilisateurDao.login(email,password);
    }

    @Override
    public Utilisateur utilisateurEmail(String email) {
        return utilisateurDao.utilisateurEmail(email);
    }
}
