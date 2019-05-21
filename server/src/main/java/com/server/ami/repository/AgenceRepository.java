package com.server.ami.repository;

import com.server.ami.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(exported = false)
public interface AgenceRepository extends JpaRepository<Agence, Integer> {
}

