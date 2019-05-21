import {Component, OnInit} from '@angular/core';
import {Agence} from '../../../model/agence';
import {AgenceService} from '../../../services/agence/agence.service';
import * as L from 'leaflet';
import {any} from 'codelyzer/util/function';
import {FilterPipe} from 'ngx-filter-pipe';


@Component({
  selector: 'app-agence',
  templateUrl: './agence.component.html',
  styleUrls: ['./agence.component.css']
})

export class AgenceComponent implements OnInit {

  agences: Agence[];
  agencesFilter: any = { adresse: '' };
  agencesFilter2: any = { gouvernorat : '' };

  constructor( private agenceService: AgenceService) {
  }
  ngOnInit() {

    const map = L.map('map').setView([34.269, 9.429], 7);

    L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {}).addTo(map);
    const myIcon = L.divIcon({className: 'fa fa-map-marker fa-4x '});


    this.agenceService.getAgences().subscribe(data => {
      this.agences = data;

      data.forEach(childObj => {

        L.marker([childObj.longitude, childObj.aptitude])
          .addTo(map)
          .bindPopup('<ul class="user-setting-menu">\n' +
            '      <li><b>' + childObj.nom + '</b></li>\n' +
            '      <li><i class="fa fa-phone text-danger p-1"></i>' + childObj.telephone + '</li>\n' +
            '      <li><i class="fa fa-mobile text-danger p-1"></i>' + childObj.gsm + '</li>\n' +
            '      <li><i class="fa fa-fax text-danger p-1"></i>' + childObj.fax + '</li>\n' +
            '      <li><i class="fa fa-location-arrow text-danger p-1"></i>' + childObj.adresse + '</li>\n' +
            '      </ul>');

      });
    });



  }

}
