package com.server.ami.dao;

import com.server.ami.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ResultatDaoImpl implements ResultatDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean ajouter(Resultat resultat) {
        try{

            entityManager.persist(resultat);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Resultat resultat) {
        try{
            entityManager.remove(resultat);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean modifier(Resultat resultat) {
        return false;
    }

    @Override
    public List<Resultat> list() {
        try {
            String sql = "FROM Resultat as resultat ORDER BY resultat.date DESC";
            return (List<Resultat>)entityManager.createQuery(sql)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Resultat resultat(String id) {
        try {
            return entityManager.find(Resultat.class,id);
        } catch (Exception ex) {
            return null;
        }
    }


}
