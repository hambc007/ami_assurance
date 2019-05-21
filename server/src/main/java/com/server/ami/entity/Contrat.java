package com.server.ami.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="contrat"
        ,catalog="ami"
)
public class Contrat implements Serializable {

    private String id;
    private String numero_serie;
    private String type;
    private Date date_creation;
    private Date date_debut;
    private Date date_fin;
    private Utilisateur client;
    private Agence agence;
    private int status;
    private double montant;
    private String description;

    private Set<Declaration> declaration = new HashSet<Declaration>(0);

    public Contrat() {}

    public Contrat(String id, String numero_serie, String type, Date date_creation, Date date_debut, Date date_fin, Utilisateur client, Agence agence, int status, double montant, String description) {
        this.id = id;
        this.numero_serie = numero_serie;
        this.type = type;
        this.date_creation = date_creation;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
        this.client = client;
        this.agence = agence;
        this.status = status;
        this.montant = montant;
        this.description = description;
    }

    @Id
    @Column(name="id", unique=true, nullable=false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name="numero_serie", length=30, unique=true, nullable=false)
    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    @Column(name="type", length=15, nullable=false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="date_creation", length=19, updatable=false)
    public Date getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(Date date_creation) {
        this.date_creation = date_creation;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_debut", length=19, updatable=true)
    public Date getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="date_fin", length=19, updatable=true)
    public Date getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_client", nullable=false)
    public Utilisateur getClient() {
        return client;
    }

    public void setClient(Utilisateur client) {
        this.client = client;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_agence", nullable=false)
    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    @Column(name="status", nullable=false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name="montant", nullable=false)
    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Column(name="description", length=1000, nullable=false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(fetch=FetchType.EAGER, mappedBy="contrat")
    @JsonBackReference(value = "declaration2")
    public Set<Declaration> getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Set<Declaration> declaration) {
        this.declaration = declaration;
    }
}
