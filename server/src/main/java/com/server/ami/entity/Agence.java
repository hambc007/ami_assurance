package com.server.ami.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="agence"
        ,catalog="ami"
)
public class Agence implements Serializable {

    private String id;
    private String adresse;
    private String gouvernorat;
    private String nom;
    private String telephone;
    private String fax;
    private String gsm;
    private float longitude;
    private float aptitude;

    private Set<Contrat> contrats = new HashSet<Contrat>(0);

    public Agence() {
    }

    public Agence(String id, String adresse, String gouvernorat, String nom, String telephone, String fax, String gsm, float longitude, float aptitude, Set<Contrat> contrats) {
        this.id = id;
        this.adresse = adresse;
        this.gouvernorat = gouvernorat;
        this.nom = nom;
        this.telephone = telephone;
        this.fax = fax;
        this.gsm = gsm;
        this.longitude = longitude;
        this.aptitude = aptitude;
        this.contrats = contrats;
    }

    @Id
    @Column(name="id", unique=true, nullable=false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name="adresse", length=80, nullable=false)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Column(name="gouvernorat", length=100, nullable=false)
    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    @Column(name="nom", length=100, nullable=false)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name="telephone", length=20, nullable=false)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name="fax", length=20, nullable=false)
    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Column(name="gsm", length=20, nullable=false)
    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    @Column(name="longitude", nullable=false, precision=12, scale=0)
    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Column(name="aptitude", nullable=false, precision=12, scale=0)
    public float getAptitude() {
        return aptitude;
    }

    public void setAptitude(float aptitude) {
        this.aptitude = aptitude;
    }

    @OneToMany(fetch=FetchType.EAGER, mappedBy="agence")
    @JsonBackReference(value = "contrats")
    public Set<Contrat> getContrats() {
        return contrats;
    }

    public void setContrats(Set<Contrat> contrats) {
        this.contrats = contrats;
    }
}
