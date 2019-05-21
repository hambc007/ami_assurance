package com.server.ami.dao;

import com.server.ami.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class NotificationDaoImpl implements NotificationDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean ajouter(Notification notification) {
        try{

            entityManager.persist(notification);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Notification notification) {
        try{
            entityManager.remove(notification);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean modifier(Notification notification) {
        return false;
    }

    @Override
    public List<Notification> list() {
        try {
            String sql = "FROM Notification as notification ORDER BY notification.date DESC";
            return (List<Notification>)entityManager.createQuery(sql)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public List<Notification> list(String id_recepteur) {
        try {
            String sql = "FROM Notification as notification WHERE notification.recepteur.id =id_recepteur  ORDER BY notification.date DESC";
            return (List<Notification>)entityManager.createQuery(sql)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Notification notification(String id) {
        try {
            return entityManager.find(Notification.class,id);
        } catch (Exception ex) {
            return null;
        }
    }


}
