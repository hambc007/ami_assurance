package com.server.ami.controller;

import com.server.ami.entity.*;
import com.server.ami.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping({"api/notification"})
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class NotificationController {


    @Autowired
    private NotificationService notificationService;


    @GetMapping("/{id}")
    public ResponseEntity<Notification> getById(@PathVariable("id") String id) {
        Notification notification = notificationService.notification(id);
        return new ResponseEntity<Notification>(notification, HttpStatus.OK);
    }

    @GetMapping("/list/{id}")
    public ResponseEntity<List<Notification>> getAll(@PathVariable("id") String id) {
        List<Notification> list = notificationService.list(id);
        return new ResponseEntity<List<Notification>>(list, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Notification>> getAll() {
        List<Notification> list = notificationService.list();
        return new ResponseEntity<List<Notification>>(list, HttpStatus.OK);
    }


    @PostMapping("/ajouter")
    public ResponseEntity<Notification> addNotification(@RequestBody Notification notification, UriComponentsBuilder builder) {
        notificationService.ajouter(notification);
        return new ResponseEntity<Notification>(notification, HttpStatus.CREATED);
    }


    @PutMapping("/modifier")
    public ResponseEntity<Notification> updateNotification(@RequestBody Utilisateur recepteur) {

        List<Notification> notificationData = notificationService.list();
        if (notificationData != null) {


            for (int i = 0; i < notificationData.size(); i++) {
                if (notificationData.get(i).getRecepteur().getId().equals(recepteur.getId())) {
                    notificationData.get(i).setVu(1);
                }
                new ResponseEntity(notificationService.ajouter(notificationData.get(i)), HttpStatus.OK);
            }
            //return new ResponseEntity(notificationService.ajouter(notificationData), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return null;
    }


    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable("id") String id) {
        notificationService.supprimer(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
