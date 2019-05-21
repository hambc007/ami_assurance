package com.server.ami.service;

import com.server.ami.dao.*;
import com.server.ami.dao.*;
import com.server.ami.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DeclarationServiceImpl implements DeclarationService {


    @Autowired
    private DeclarationDao declarationDao = new DeclarationDaoImpl();


    @Override
    public boolean ajouter(Declaration declaration) {
        return declarationDao.ajouter(declaration);
    }

    @Override
    public boolean supprimer(String id) {
        return declarationDao.supprimer(this.declaration(id));
    }

    @Override
            public boolean modifier(Declaration declaration) {
        return declarationDao.modifier(declaration);
    }

    @Override
    public List<Declaration> list() {
        return declarationDao.list();
    }

    @Override
    public Declaration declaration(String id) {
        return declarationDao.declaration(id);
    }
}
