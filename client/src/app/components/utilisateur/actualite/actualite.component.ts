import {Component, OnInit} from '@angular/core';
import {Actualite} from '../../../model/actualite';
import {Router} from '@angular/router';
import {ActualiteService} from '../../../services/actualite/actualite.service';

@Component({
  selector: 'app-actualite',
  templateUrl: './actualite.component.html',
  styleUrls: ['./actualite.component.css']
})
export class ActualiteComponent implements OnInit {


  actualites: Actualite[];

  constructor(private actualiteService: ActualiteService) {
  }

  supprimer(actualite) {
    this.actualiteService.supprimer(actualite.id).subscribe( data => {
      this.actualites = this.actualites.filter(u => u !== actualite);
    });
  }


  ngOnInit() {
    this.actualiteService.getActualites()
      .subscribe(data => {
        this.actualites = data;
      });
  }


}
