package com.server.ami.repository;

import com.server.ami.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(exported = false)
@CrossOrigin(origins = "http://localhost:4200")
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}

