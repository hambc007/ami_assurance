package com.server.ami.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="reclamation"
        ,catalog="ami"
)
public class Reclamation {

    private String id;
    private String contenu;
    private String titre;
    private Utilisateur client;
    private Date date;
    private int traiter;

    public Reclamation() {
    }

    public Reclamation(String id, String contenu, String titre, Utilisateur client, Date date, int traiter) {
        this.id = id;
        this.contenu = contenu;
        this.titre = titre;
        this.client = client;
        this.date = date;
        this.traiter = traiter;
    }


    @Id
    @Column(name="id", unique=true, nullable=false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name="contenu", length=1000, nullable=false)
    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    @Column(name="titre", length=100, nullable=false)
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_client", nullable=false ,updatable = false)
    public Utilisateur getClient() {
        return client;
    }

    public void setClient(Utilisateur client) {
        this.client = client;
    }


    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date", length=19, updatable=false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name="traiter")
    public int getTraiter() {
        return traiter;
    }

    public void setTraiter(int traiter) {
        this.traiter = traiter;
    }
}
