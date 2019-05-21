package com.server.ami.entity;

import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="declaration"
        ,catalog="ami"
)
public class Declaration implements Serializable {

    private String id;
    private String contenu;
    private String titre;
    private Utilisateur client;
    private Contrat contrat;
    private String image;
    private Date date;
    private int traiter;

    public Declaration() {
    }

    public Declaration(String id, String contenu, String titre, Utilisateur client, Contrat contrat, String image, Date date, int traiter) {
        this.id = id;
        this.contenu = contenu;
        this.titre = titre;
        this.client = client;
        this.contrat = contrat;
        this.image = image;
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

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_contrat", nullable=false ,updatable = false)
    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
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
    @Column(name="date", length=19, updatable=false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name="traiter", nullable=false)
    public int getTraiter() {
        return traiter;
    }

    public void setTraiter(int traiter) {
        this.traiter = traiter;
    }


}
