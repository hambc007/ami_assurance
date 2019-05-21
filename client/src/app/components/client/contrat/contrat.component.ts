import { Component, OnInit } from '@angular/core';
import {ContratService} from '../../../services/contrat/contrat.service';
import {Contrat} from '../../../model/contrat';
import {Utilisateur} from '../../../model/utilisateur';

@Component({
  selector: 'app-contrat',
  templateUrl: './contrat.component.html',
  styleUrls: ['./contrat.component.css']
})
export class ContratComponent implements OnInit {

  constructor(private contratService: ContratService) { }
  contrats: Contrat[];
  utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  current= this.utilisateur
  filter: any = {client : this.current};
  ngOnInit() {
    this.contratService.getContrats()
      .subscribe( data => {
        this.contrats = data;
      });
  }

}
