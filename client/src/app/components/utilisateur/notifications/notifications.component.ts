import { Component, OnInit } from '@angular/core';
import {NotificationService} from '../../../services/notification/notification.service';
import {Utilisateur} from '../../../model/utilisateur';

@Component({
  selector: 'app-notifications',
  templateUrl: './notifications.component.html',
  styleUrls: ['./notifications.component.css']
})
export class NotificationsComponent implements OnInit {

  notifications: Notification[];
  utilisateur: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];

  constructor(private notificationService: NotificationService) { }

  nbnotificationFilter: any = { vu: 0 , recepteur: this.utilisateur };
  notificationFilter: any = { recepteur: this.utilisateur };

  modifier(id) {
    this.notificationService.modifier(this.notifications);
  }

  ngOnInit() {
    this.notificationService.getNotifications()
      .subscribe( data => {
        this.notifications = data;
      });
  }

}
