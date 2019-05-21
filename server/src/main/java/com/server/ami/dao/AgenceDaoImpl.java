package com.server.ami.dao;

import com.server.ami.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class AgenceDaoImpl implements AgenceDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean ajouter(Agence agence) {
        try{

            entityManager.persist(agence);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Agence agence) {
        try{
            entityManager.remove(agence);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean modifier(Agence agence) {
        return false;
    }

    @Override
    public List<Agence> list() {
        try {
            String sql = "FROM Agence as agence ORDER BY agence.id";
            return (List<Agence>)entityManager.createQuery(sql)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Agence agence(String id) {
        try {
            return entityManager.find(Agence.class,id);
        } catch (Exception ex) {
            return null;
        }
    }


}
