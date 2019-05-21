import { Component, OnInit } from '@angular/core';
import {ActivatedRoute,Router} from '@angular/router';

import {Actualite} from '../../../../model/actualite';
import {ActualiteService} from '../../../../services/actualite/actualite.service';

@Component({
  selector: 'app-voiractualite',
  templateUrl: './voiractualite.component.html',
  styleUrls: ['./voiractualite.component.css']
})
export class VoiractualiteComponent implements OnInit {

  constructor(private aService : ActualiteService,
    private router: Router,
                private route: ActivatedRoute) { }
  model: any = {};
  a : Actualite ;
  id = this.route.snapshot.params.id;
  ngOnInit() {
    this.aService.actualite(this.id)
      .subscribe(data => {
        this.a = data;
      });
  }
}
