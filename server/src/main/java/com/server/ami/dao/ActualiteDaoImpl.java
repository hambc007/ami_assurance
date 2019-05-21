package com.server.ami.dao;

import com.server.ami.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class ActualiteDaoImpl implements ActualiteDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean ajouter(Actualite actualite) {
        try{

            entityManager.persist(actualite);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Actualite actualite) {
        try{
            entityManager.remove(actualite);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean modifier(Actualite actualite) {
        return false;
    }

    @Override
    public List<Actualite> list() {
        try {
            String sql = "FROM Actualite as actualite ORDER BY actualite.date DESC";
            return (List<Actualite>)entityManager.createQuery(sql)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Actualite actualite(String id) {
        try {
            return entityManager.find(Actualite.class,id);
        } catch (Exception ex) {
            return null;
        }
    }


}
