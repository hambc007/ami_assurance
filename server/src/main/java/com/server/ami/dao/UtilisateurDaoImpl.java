package com.server.ami.dao;

import com.server.ami.entity.Utilisateur;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UtilisateurDaoImpl implements UtilisateurDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public boolean ajouter(Utilisateur utilisateur) {
        try{

            entityManager.persist(utilisateur);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean supprimer(Utilisateur utilisateur) {
        try{
            entityManager.remove(utilisateur);

        }catch(Exception ex){
            return false;
        }
        return true;
    }

    @Override
    public boolean modifier(Utilisateur utilisateur) {
        return false;
    }

    @Override
    public List<Utilisateur> list() {
        try {
            String sql = "FROM Utilisateur as user ORDER BY user.cin";
            return (List<Utilisateur>)entityManager.createQuery(sql)
                    .getResultList();

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Utilisateur utilisateur(String id) {
            try {
                return entityManager.find(Utilisateur.class,id);
            } catch (Exception ex) {
                return null;
            }
    }

    @Override
    public Utilisateur login(String email, String password) {
        try {

            String sql = "FROM Utilisateur as user where user.email LIKE :email and user.password LIKE :password";
            return (Utilisateur) entityManager.createQuery(sql)
                    .setParameter("email", email)
                    .setParameter("password",password)
                    .getSingleResult();

        } catch (Exception ex) {
            return null;
        }
    }

    @Override
    public Utilisateur utilisateurEmail(String email) {
        try {
            String sql = "FROM Utilisateur as user where user.email LIKE :email";
            return (Utilisateur) entityManager.createQuery(sql)
                    .setParameter("email", email)
                    .getSingleResult();

        } catch (Exception ex) {
            return null;
        }
    }


}
