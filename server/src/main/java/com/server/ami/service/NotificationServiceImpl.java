package com.server.ami.service;

import com.server.ami.dao.*;
import com.server.ami.dao.*;
import com.server.ami.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NotificationServiceImpl implements NotificationService {


    @Autowired
    private NotificationDao notificationDao = new NotificationDaoImpl();


    @Override
    public boolean ajouter(Notification notification) {
        return notificationDao.ajouter(notification);
    }

    @Override
    public boolean supprimer(String id) {
        return notificationDao.supprimer(this.notification(id));
    }

    @Override
    public boolean modifier(Notification notification) {
        return notificationDao.modifier(notification);
    }

    @Override
    public List<Notification> list() {
        return notificationDao.list();
    }

    @Override
    public List<Notification> list(String id_recepteur) {

        return notificationDao.list(id_recepteur);
    }

    @Override
    public Notification notification(String id) {
        return notificationDao.notification(id);
    }
}
