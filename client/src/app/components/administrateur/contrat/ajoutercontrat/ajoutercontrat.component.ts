import {Component, OnInit} from '@angular/core';
import {UtilisateurService} from '../../../../services/utilisateur/utilisateur.service';
import {Router} from '@angular/router';
import {NotificationService} from '../../../../services/notification/notification.service';
import {HttpClient} from '@angular/common/http';
import {UUID} from 'angular2-uuid';
import {ContratService} from '../../../../services/contrat/contrat.service';
import {Utilisateur} from '../../../../model/utilisateur';
import {Agence} from '../../../../model/agence';
import {AgenceService} from '../../../../services/agence/agence.service';
import * as L from 'leaflet';

@Component({
  selector: 'app-ajoutercontrat',
  templateUrl: './ajoutercontrat.component.html',
  styleUrls: ['./ajoutercontrat.component.css']
})
export class AjoutercontratComponent implements OnInit {

  constructor(private router: Router,
              private agenceService: AgenceService,
              private contratService: ContratService,
              private notificationService: NotificationService,
              private utilisateurService: UtilisateurService,
              private http: HttpClient) {
  }
  utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];

  model: any = {};
  error = false;
  agences: Agence[];
  clients: Utilisateur[];

  clientFilter: any = {recepteur: {id: '1', role: 'client'}};


  ajouter() {

    const contrat = {
      id: UUID.UUID(),
      client: {id: this.model.client},
      agence: {id: this.model.agence},
      numero_serie: 'AMI-' + Math.floor(Math.random() * 9999) + 1,
      type: this.model.type,
      date_debut: this.model.date_debut,
      date_fin: this.model.date_fin,
      status: 1,
      montant: this.model.montant,
      description: this.model.description
    };

    this.contratService.ajouter(contrat).subscribe(data => {
      if (data) {


        this.notificationService.ajouter({
          id: UUID.UUID(),
          lien: 'contrat',
          objet: 'Félicitation pour votre nouveau contrat',
          image: null,
          recepteur: contrat.client,
          vu: 0
        }).subscribe();
        window.alert("contrat a été ajouté avec succès ");


        this.router.navigate(['contrat/recherche']);
      } else {
        this.error = true;
      }
    });

  }


  ngOnInit() {


    this.agenceService.getAgences().subscribe(data => {
      this.agences = data;
    });

    this.utilisateurService.list().subscribe(data => {
      this.clients = data;
    });


  }


}
