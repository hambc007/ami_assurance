import { Component, OnInit } from '@angular/core';
import {ContratService} from '../../../../services/contrat/contrat.service';
import {UtilisateurService} from '../../../../services/utilisateur/utilisateur.service';
import {Utilisateur} from '../../../../model/utilisateur';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  utilisateurs: Utilisateur[];
  constructor(private utilisateurService: UtilisateurService) { }

  supprimer(utilisateur) {
    this.utilisateurService.supprimer(utilisateur) .subscribe( data => {
      this.utilisateurs = this.utilisateurs.filter(u => u !== utilisateur);
    });
  }

  ngOnInit() {
    this.utilisateurService.list()
      .subscribe( data => {
        this.utilisateurs = data.filter(u => u.role.id !== '1');
      });
  }

}
