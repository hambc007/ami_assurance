package com.server.ami.dao;

import com.server.ami.entity.*;

import java.util.List;

public interface NotificationDao {

    public boolean ajouter(Notification notification);
    public boolean supprimer(Notification notification);
    public boolean modifier(Notification notification);
    public List<Notification> list();
    public List<Notification> list(String id_recepteur);
    public Notification notification(String id);

}
