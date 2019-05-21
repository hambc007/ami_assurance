import { Component, OnInit } from '@angular/core';
import {NotificationService} from '../../../../../services/notification/notification.service';
import {Utilisateur} from '../../../../../model/utilisateur';

@Component({
  selector: 'app-notification',
  templateUrl: './notification.component.html',
  styleUrls: ['./notification.component.css']
})
export class NotificationComponent implements OnInit {

  notifications: Notification[];
  utilisateur: Utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];

  constructor(private notificationService: NotificationService) { }

  nbnotificationFilter: any = { vu: 0 , recepteur: this.utilisateur };
  notificationFilter: any = { recepteur: this.utilisateur };

   modifier() {
    this.notificationService.modifier(this.utilisateur).subscribe();
  }

  ngOnInit() {
    this.notificationService.getNotifications()
      .subscribe( data => {
        this.notifications = data;
      });
  }

}
