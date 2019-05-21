package com.server.ami.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name="actualite"
        ,catalog="ami"
)
public class Actualite implements Serializable {

    private String id;
    private String contenu;
    private String titre;
    private String image;
    private Date date;

    public Actualite() {
    }

    public Actualite(String id, String contenu, String titre, String image, Date date) {
        this.id = id;
        this.contenu = contenu;
        this.titre = titre;
        this.image = image;
        this.date = date;
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

    @Column(name="image", columnDefinition="longblob")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
}
