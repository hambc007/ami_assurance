package com.server.ami.dao;

import com.server.ami.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class DeclarationDaoImpl implements DeclarationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean ajouter(Declaration declaration) {
        try{

            entityManager.persist(declaration);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Declaration declaration) {
        try{
            entityManager.remove(declaration);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean modifier(Declaration declaration) {
        return false;
    }

    @Override
    public List<Declaration> list() {
        try {
            String sql = "FROM Declaration as declaration ORDER BY declaration.date DESC";
            return (List<Declaration>)entityManager.createQuery(sql)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }
    }



    @Override
    public Declaration declaration(String id) {
        try {
            return entityManager.find(Declaration.class,id);
        } catch (Exception ex) {
            return null;
        }
    }


}
