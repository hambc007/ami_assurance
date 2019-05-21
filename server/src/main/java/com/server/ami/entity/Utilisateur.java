package com.server.ami.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="utilisateur"
        ,catalog="ami"
)
public class Utilisateur implements Serializable {

    private String id;
    private String cin;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    private String telephone;
    private String adresse;
    private Date datenaissance;
    private String image;
    private Role role;

    private Set<Contrat> contrat = new HashSet<Contrat>(0);
    private Set<Notification> notification = new HashSet<Notification>(0);
    private Set<Reclamation> reclamation = new HashSet<Reclamation>(0);
    private Set<Declaration> declaration = new HashSet<Declaration>(0);

    public Utilisateur() {}

    public Utilisateur(String id, String cin, String nom, String prenom, String email, String password, String telephone, String adresse, Date datenaissance, String image, Role role) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.adresse = adresse;
        this.datenaissance = datenaissance;
        this.image = image;
        this.role = role;
    }

    public Utilisateur(String id, String cin, String nom, String prenom, String email, String password, String telephone, String adresse, Date datenaissance, String image, Role role, Set<Contrat> contrat, Set<Notification> notification, Set<Reclamation> reclamation) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.adresse = adresse;
        this.datenaissance = datenaissance;
        this.image = image;
        this.role = role;
        this.contrat = contrat;
        this.notification = notification;
        this.reclamation = reclamation;
    }

    @Id
    @Column(name="id", unique=true, nullable=false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name="cin", length=8, unique=true, nullable=false)
    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    @Column(name="nom", length=30, nullable=false)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name="prenom", length=30, nullable=false)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column(name="email", length=100, unique=true, nullable=false)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name="password", length=100, nullable=false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="telephone", length=15, unique=true, nullable=false)
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Column(name="adresse", length=400, unique=true, nullable=false)
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="datenaissance", length=19, updatable=false)
    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    @Column(name="image", columnDefinition="blob")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="id_role", nullable=false ,updatable = false)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @OneToMany(fetch=FetchType.EAGER, mappedBy="client")
    @JsonBackReference(value = "contrat")
    public Set<Contrat> getContrat() {
        return contrat;
    }

    public void setContrat(Set<Contrat> contrat) {
        this.contrat = contrat;
    }


    @OneToMany(fetch=FetchType.EAGER, mappedBy="recepteur")
    @JsonBackReference(value = "recepteur")
    public Set<Notification> getNotification() {
        return notification;
    }

    public void setNotification(Set<Notification> notification) {
        this.notification = notification;
    }

    @OneToMany(fetch=FetchType.EAGER, mappedBy="client")
    @JsonBackReference(value = "reclamation")
    public Set<Reclamation> getReclamation() {
        return reclamation;
    }

    public void setReclamation(Set<Reclamation> reclamation) {
        this.reclamation = reclamation;
    }

    @OneToMany(fetch=FetchType.EAGER, mappedBy="client")
    @JsonBackReference(value = "declaration1")
    public Set<Declaration> getDeclaration() {
        return declaration;
    }

    public void setDeclaration(Set<Declaration> declaration) {
        this.declaration = declaration;
    }

}
