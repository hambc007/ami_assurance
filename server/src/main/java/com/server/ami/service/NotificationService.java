package com.server.ami.service;

import com.server.ami.entity.*;

import java.util.List;

public interface NotificationService {

    public boolean ajouter(Notification notification);
    public boolean supprimer(String id);
    public boolean modifier(Notification notification);
    public List<Notification> list();
    public List<Notification> list(String id_recepteur);
    public Notification notification(String id);

}
