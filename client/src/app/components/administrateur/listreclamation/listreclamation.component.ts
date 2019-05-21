import {Component, OnInit} from '@angular/core';
import {Utilisateur} from '../../../model/utilisateur';
import {UtilisateurService} from '../../../services/utilisateur/utilisateur.service';
import {ReclamationService} from '../../../services/reclamation/reclamation.service';
import {Reclamation} from '../../../model/reclamation';

@Component({
  selector: 'app-listreclamation',
  templateUrl: './listreclamation.component.html',
  styleUrls: ['./listreclamation.component.css']
})
export class ListreclamationComponent implements OnInit {

  reclamations: Reclamation[];

  constructor(private reclamationService: ReclamationService) {
  }

  filter: any = {traiter: 0};

  ngOnInit() {
    this.reclamationService.list()
      .subscribe(data => {
        this.reclamations = data;
      });
  }

}
