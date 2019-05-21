package com.server.ami.dao;

import com.server.ami.entity.*;

import java.util.List;

public interface DeclarationDao {

    public boolean ajouter(Declaration declaration);
    public boolean supprimer(Declaration declaration);
    public boolean modifier(Declaration declaration);
    public List<Declaration> list();
    public Declaration declaration(String id);

}
