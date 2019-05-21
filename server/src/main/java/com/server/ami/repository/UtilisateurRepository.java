package com.server.ami.repository;

import com.server.ami.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
}
