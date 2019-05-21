import {Component, OnInit} from '@angular/core';
import {ContratService} from '../../../../services/contrat/contrat.service';
import {Contrat} from '../../../../model/contrat';
import {AgenceService} from '../../../../services/agence/agence.service';
import {Agence} from '../../../../model/agence';

@Component({
  selector: 'app-recherche',
  templateUrl: './recherche.component.html',
  styleUrls: ['./recherche.component.css']
})
export class RechercheComponent implements OnInit {

  constructor(private contratService: ContratService, private agenceService: AgenceService) { }
  contrats: Contrat[];
  agences: Agence[];

  filter: any = {client : {cin : ''}, agence : {nom : ''}, montant : '', numero_serie : '', status : '', type : ''};



  ngOnInit() {
    this.contratService.getContrats()
      .subscribe( data => {
        this.contrats = data;
      });
    this.agenceService.getAgences()
      .subscribe( data => {
        this.agences = data;
      });
  }

}
