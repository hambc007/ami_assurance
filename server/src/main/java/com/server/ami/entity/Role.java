package com.server.ami.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role"
        ,catalog="ami"
)
public class Role implements Serializable {

    private String id;
    private String role;

    private Set<Utilisateur> utilisateur = new HashSet<Utilisateur>(0);

    public Role() {
    }

    public Role(String id, String role) {
        this.id = id;
        this.role = role;
    }

    public Role(String id, String role, Set<Utilisateur> utilisateur) {
        this.id = id;
        this.role = role;
        this.utilisateur = utilisateur;
    }

    @Id
    @Column(name="id", unique=true, nullable=false)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name="role", length=15, nullable=false)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @OneToMany(fetch=FetchType.EAGER, mappedBy="role")
    @JsonBackReference(value = "role")
    public Set<Utilisateur> getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Set<Utilisateur> utilisateur) {
        this.utilisateur = utilisateur;
    }
}
