import { Component, OnInit } from '@angular/core';
import {Resultat} from '../../model/resultat';
import {Utilisateur} from '../../model/utilisateur';
import {Declaration} from '../../model/declaration';


import {ResultatService} from '../../services/resultat/resultat.service';
@Component({
  selector: 'app-historique',
  templateUrl: './historique.component.html',
  styleUrls: ['./historique.component.css']
})
export class HistoriqueComponent implements OnInit {
  resultats: Resultat[];

  utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];

    filter: any = {client : this.utilisateur};
  constructor(private resultatService : ResultatService) { }

  ngOnInit() {
    this.resultatService.list()
      .subscribe(data => {
        this.resultats = data; }) ;
  }

}
