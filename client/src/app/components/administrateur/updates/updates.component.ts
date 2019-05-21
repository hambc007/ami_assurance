import { Component, OnInit } from '@angular/core';
import {Resultat} from '../../../model/resultat';
import {Declaration} from '../../../model/declaration';

import {UtilisateurService} from '../../../services/utilisateur/utilisateur.service';

import {ResultatService} from '../../../services/resultat/resultat.service';
import {ActivatedRoute, Router} from '@angular/router';
import {NotificationService} from '../../../services/notification/notification.service';
import {UUID} from 'angular2-uuid';
import {Validators} from '@angular/forms';



@Component({
  selector: 'app-updates',
  templateUrl: './updates.component.html',
  styleUrls: ['./updates.component.css']
})
export class UpdatesComponent implements OnInit {

  constructor(    private resultatService: ResultatService,
                  private notificationService: NotificationService,
                  private utilisateurService: UtilisateurService,
                  private router: Router,
                  private route: ActivatedRoute) {}
                  model: any = {};
                  id = this.route.snapshot.params.id;
                  error = false;
                  R = Resultat;
    modifier() {
      this.resultatService.ajouter(this.id).subscribe(data => {
        if (data) {
          this.notificationService.ajouter({
            id: UUID.UUID(),
            lien: 'update',
            objet: 'la resultat a éte ajouter avec succes',
            image: null,
            vu: 0
          }).subscribe();
          window.alert("sinistre a été ajouté avec succès ");

          this.router.navigate(['/update']);
        } else {
          this.error = true;
        }}
      );
    }

  ngOnInit() {
  }

}
