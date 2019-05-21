package com.server.ami.service;

import com.server.ami.entity.*;

import java.util.List;

public interface DeclarationService {

    public boolean ajouter(Declaration declaration);
    public boolean supprimer(String id);
    public boolean modifier(Declaration declaration);
    public List<Declaration> list();
    public Declaration declaration(String id);

}
