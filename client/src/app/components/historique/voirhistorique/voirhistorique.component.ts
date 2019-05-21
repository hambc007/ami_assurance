import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';

import {ResultatService} from '../../../services/resultat/resultat.service';
import {Resultat} from '../../../model/resultat';



@Component({
  selector: 'app-voirhistorique',
  templateUrl: './voirhistorique.component.html',
  styleUrls: ['./voirhistorique.component.css']
})
export class VoirhistoriqueComponent implements OnInit {

  constructor(private resultatService : ResultatService,
    private router: Router,
                private route: ActivatedRoute) { }
  model: any = {};
  resultat: Resultat ;
  id = this.route.snapshot.params.id;
  ngOnInit() {
    this.resultatService.resultat(this.id)
      .subscribe(data => {
        this.resultat = data;
      });
  }
}
