package com.server.ami.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.*;
import java.util.*;

@Entity
@Table(name="resultat"
        ,catalog="ami"
)
public class Resultat implements Serializable {

    private String id;
    private Date date;
    private String resultat;
    private String etat;

    private float montant;
    private String description;
    private Utilisateur client;
    private Contrat contrat;


    public Resultat() {
    }

    public Resultat(String id, Date date, String resultat, float montant,String description,String etat) {
        this.id = id;
        this.date = date;
        this.etat = etat;
        this.resultat = resultat;
        this.montant = montant;
        this.description= description;
    }

    public Resultat(String id, Date date, String resultat,String etat, float montant ,String description, Utilisateur declaration, Contrat contrat) {
        this.id = id;
        this.date = date;
        this.resultat = resultat;
        this.etat = etat;

        this.montant = montant;
        this.description= description;
        this.client = declaration;
        this.contrat = contrat;
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
    @Column(name="date", length=19, updatable=false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name="resultat", length=30, nullable=true)
    public String getResultat() {
        return resultat;
    }

    public void setResultat(String resultat) {
        this.resultat = resultat;
    }
    @Column(name="etat", length=30, nullable=false)
    public String getEtat() {
        return etat;
    }

    public void setEtat(String resultat) {
        this.etat = resultat;
    }

    @Column(name="montant", nullable=false)
    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }
    @Column(name="description", length=500, nullable=false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String resultat) {
        this.description = resultat;
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

    public void setContrat(Contrat client) {
        this.contrat = client;
    }
}
