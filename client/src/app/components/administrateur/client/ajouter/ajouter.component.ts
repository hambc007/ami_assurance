import {Component, OnInit} from '@angular/core';
import {ActualiteService} from '../../../../services/actualite/actualite.service';
import {NotificationService} from '../../../../services/notification/notification.service';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {UtilisateurService} from '../../../../services/utilisateur/utilisateur.service';
import {Validators} from '@angular/forms';
import {Role} from '../../../../model/role';
import {UUID} from 'angular2-uuid';

@Component({
  selector: 'app-ajouter',
  templateUrl: './ajouter.component.html',
  styleUrls: ['./ajouter.component.css']
})
export class AjouterComponent implements OnInit {

  constructor(private utilisateurService: UtilisateurService,
              private router: Router,
              private notificationService: NotificationService,
              private http: HttpClient) {
  }

  model: any = {};
  error = false;


  ajouter() {

    const utilisateur = {
      id: UUID.UUID(),
      cin: this.model.cin,
      nom: this.model.nom,
      prenom: this.model.prenom,
      email: this.model.email,
      password: this.model.cin,
      telephone: this.model.telephone,
      adresse: this.model.adresse,
      datenaissance: null,
      image: null,
      role: {
        id: '1',
        role: 'client'
      }
    };
    this.utilisateurService.ajouter(utilisateur).subscribe(data => {
      if (data) {

        this.notificationService.ajouter({
          id: UUID.UUID(),
          lien: 'actualite',
          objet: 'Bienvenue dans AMI Assurances',
          image: null,
          recepteur: utilisateur,
          vu: 0
        }).subscribe();
        window.alert("client a été ajouté avec succès ");

        this.router.navigate(['/client/list']);
      } else {
        this.error = true;
      }
    });
  }


  ngOnInit() {

  }


}
