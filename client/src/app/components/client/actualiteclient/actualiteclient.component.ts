import {Component, OnInit} from '@angular/core';
import {Actualite} from '../../../model/actualite';
import {Router} from '@angular/router';
import {ActualiteService} from '../../../services/actualite/actualite.service';

@Component({
  selector: 'app-actualiteclient',
  templateUrl: './actualiteclient.component.html',
  styleUrls: ['./actualiteclient.component.css']
})
export class ActualiteclientComponent implements OnInit {

  constructor(private actualiteService: ActualiteService) { }
  actualites: Actualite[];

  ngOnInit() {
    this.actualiteService.getActualites()
      .subscribe(data => {
        this.actualites = data;
      });
  }
}
