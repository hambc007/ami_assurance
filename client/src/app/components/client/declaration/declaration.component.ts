import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {ContratService} from '../../../services/contrat/contrat.service';
import {NotificationService} from '../../../services/notification/notification.service';
import {UtilisateurService} from '../../../services/utilisateur/utilisateur.service';
import {HttpClient} from '@angular/common/http';
import {Contrat} from '../../../model/contrat';
import {Utilisateur} from '../../../model/utilisateur';

import {UUID} from 'angular2-uuid';
import {DeclarationService} from '../../../services/declaration/declaration.service';

@Component({
  selector: 'app-declaration',
  templateUrl: './declaration.component.html',
  styleUrls: ['./declaration.component.css']
})
export class DeclarationComponent implements OnInit {


  constructor(private router: Router,
              private contratService: ContratService,
              private declarationService: DeclarationService,
              private notificationService: NotificationService,
              private utilisateurService: UtilisateurService,
              private http: HttpClient) {
  }

  contrats: Contrat[];

  utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  current= this.utilisateur
  filter: any = {client : this.current};

  model: any = {};
  error = false;


  changeimage(files) {
    const reader = new FileReader();
    reader.readAsDataURL(files[0]);
    reader.onload = (_event) => {
      this.model.image = reader.result;
    };
  }

  ajouter() {
    const declaration =  {
      'id': UUID.UUID(),
      'contenu': this.model.contenu,
      'titre': this.model.titre,
      'client': this.utilisateur,
      'contrat':  {id: this.model.contrat},
      'image': this.model.image,
      'traiter': 0,
    };

    this.declarationService.ajouter(declaration)
      .subscribe(data => {
        window.alert("declaratiion a éte envoyée");

        this.router.navigate(['actualiteclient']);

      });
  }


  ngOnInit() {
    this.contratService.getContrats()
      .subscribe(data => {
        this.contrats = data;
      });
  }


}
