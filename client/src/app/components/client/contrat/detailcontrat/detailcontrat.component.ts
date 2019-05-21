import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {ContratService} from '../../../../services/contrat/contrat.service';
import {Contrat} from '../../../../model/contrat';

@Component({
  selector: 'app-detailcontrat',
  templateUrl: './detailcontrat.component.html',
  styleUrls: ['./detailcontrat.component.css']
})
export class DetailcontratComponent implements OnInit {

  constructor(private contratService: ContratService , private route: ActivatedRoute) { }
  contrat: Contrat;
  id = this.route.snapshot.params.id;

  ngOnInit() {
    this.contratService.getContrat(this.id)
      .subscribe( data => {
        this.contrat = data;
      });
  }

}
