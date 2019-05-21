import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {AgenceService} from '../../../../services/agence/agence.service';
import {ContratService} from '../../../../services/contrat/contrat.service';
import {NotificationService} from '../../../../services/notification/notification.service';
import {UtilisateurService} from '../../../../services/utilisateur/utilisateur.service';
import {DeclarationService} from '../../../../services/declaration/declaration.service';
import {ResultatService} from '../../../../services/resultat/resultat.service';
import {Resultat} from '../../../../model/resultat';

import {Declaration} from '../../../../model/declaration';
import {HttpClient} from '@angular/common/http';
import {UUID} from 'angular2-uuid';



@Component({
  selector: 'app-ajouterresultat',
  templateUrl: './ajouterresultat.component.html',
  styleUrls: ['./ajouterresultat.component.css']
})
export class AjouterresultatComponent implements OnInit {


  constructor(private router: Router,
              private route: ActivatedRoute,
              private declarationService :DeclarationService,
              private contratService: ContratService,
              private notificationService: NotificationService,
              private utilisateurService: UtilisateurService,
              private resultatService: ResultatService,

              private http: HttpClient)
              {

              }
              model: any = {};
              declaration: Declaration;
              id = this.route.snapshot.params.id;
              modifier() {
                const resultat = {
                  id: UUID.UUID(),
                  date: Date.now() ,
                  resultat: "en cours de traitement",
                  montant: null,
                  declaration: this.model.declaration ,
                };
                this.resultatService.ajouter(resultat).subscribe(),
                this.declarationService.modifier(this.id).subscribe(data => {

                  this.notificationService.ajouter({
                    id: UUID.UUID(),
                    lien: 'actualite',
                    objet: 'Votre declaration était traitée',
                    image: null,
                    recepteur: this.declaration.client,
                    vu: 0
                  }).subscribe();


                });

                this.router.navigate(['/declaration/list']);

              }
              ngOnInit() {
                this.declarationService.declaration(this.id)
                  .subscribe(data => {
                    this.declaration = data;
                  });
              }


}
