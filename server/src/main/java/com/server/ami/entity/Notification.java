package com.server.ami.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="notification"
        ,catalog="ami"
)
public class Notification implements Serializable {

    private String id;
    private Date date;
    private String lien;
    private String objet;
    private Utilisateur recepteur;
    private String image;
    private int vu;

    public Notification() {}

    public Notification(String id, Date date, String lien, String objet, Utilisateur recepteur, String image, int vu) {
        this.id = id;
        this.date = date;
        this.lien = lien;
        this.objet = objet;
        this.recepteur = recepteur;
        this.image = image;
        this.vu = vu;
    }

    @Id
    @Column(name="id", unique=true, nullable=false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_creation", length=19, updatable=false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name="lien", length=200, nullable=false )
    public String getLien() {
        return lien;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    @Column(name="objet", length=100, nullable=false)
    public String getObjet() {
        return objet;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_recepteur")
    public Utilisateur getRecepteur() {
        return recepteur;
    }

    public void setRecepteur(Utilisateur recepteur) {
        this.recepteur = recepteur;
    }

    @Column(name="image", columnDefinition="longblob")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Column(name="vue")
    public int getVu() {
        return vu;
    }

    public void setVu(int vu) {
        this.vu = vu;
    }
}
