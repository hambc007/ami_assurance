import {Component, OnInit} from '@angular/core';
import {SecuriteService} from '../../../services/securite/securite.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {ReclamationService} from '../../../services/reclamation/reclamation.service';
import {UUID} from 'angular2-uuid';
import {Utilisateur} from '../../../model/utilisateur';
import {NotificationService} from '../../../services/notification/notification.service';

@Component({
  selector: 'app-reclamation',
  templateUrl: './reclamation.component.html',
  styleUrls: ['./reclamation.component.css']
})
export class ReclamationComponent implements OnInit {


  utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];

  model: any = {};
  result = false;
  error = false;

  constructor(private reclamationService: ReclamationService,
              private notificationService: NotificationService,
              private router: Router,
              private http: HttpClient) {
  }


  ajouter() {
    const reclamation = {
      id: UUID.UUID(),
      contenu: this.model.contenu,
      titre: this.model.titre,
      client: this.utilisateur,
      traiter: 0
    };

    this.reclamationService.ajouter(reclamation).subscribe(data => {
      if (data) {

        window.alert("reclamation a éte envoyée");
        this.result = true;

          this.router.navigate(['actualiteclient']);
      } else {
        this.error = true;
      }
    });
  }

  ngOnInit() {
  }

}
