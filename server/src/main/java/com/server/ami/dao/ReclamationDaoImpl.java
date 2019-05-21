package com.server.ami.dao;

import com.server.ami.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ReclamationDaoImpl implements ReclamationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean ajouter(Reclamation reclamation) {
        try{

            entityManager.persist(reclamation);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Reclamation reclamation) {
        try{
            entityManager.remove(reclamation);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean modifier(Reclamation reclamation) {
        return false;
    }

    @Override
    public List<Reclamation> list() {
        try {
            String sql = "FROM Reclamation as reclamation ORDER BY reclamation.date DESC";
            return (List<Reclamation>)entityManager.createQuery(sql)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Reclamation reclamation(String id) {
        try {
            return entityManager.find(Reclamation.class,id);
        } catch (Exception ex) {
            return null;
        }
    }


}
