package com.server.ami.dao;

import com.server.ami.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ContratDaoImpl implements ContratDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean ajouter(Contrat contrat) {
        try{

            entityManager.persist(contrat);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Contrat contrat) {
        try{
            entityManager.remove(contrat);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean modifier(Contrat contrat) {
        return false;
    }

    @Override
    public List<Contrat> list() {
        try {
            String sql = "FROM Contrat as contrat ORDER BY contrat.id";
            return (List<Contrat>)entityManager.createQuery(sql)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Contrat contrat(String id) {
        try {
            return entityManager.find(Contrat.class,id);
        } catch (Exception ex) {
            return null;
        }
    }


}
