import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {ActualiteService} from '../../../services/actualite/actualite.service';
import {NotificationService} from '../../../services/notification/notification.service';
import {Utilisateur} from '../../../model/utilisateur';
import {UUID} from 'angular2-uuid';

@Component({
  selector: 'app-actualites',
  templateUrl: './actualites.component.html',
  styleUrls: ['./actualites.component.css']
})
export class ActualitesComponent implements OnInit {

  constructor(private actualiteService: ActualiteService,
              private notificationService: NotificationService,
              private router: Router,
              private http: HttpClient) {
  }

  model: any = {};
  error = false;
  utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];


  changeimage(files) {
    const reader = new FileReader();
    reader.readAsDataURL(files[0]);
    reader.onload = (_event) => {
      this.model.image = reader.result;
    };
  }


  ajouter() {


    this.actualiteService.ajouter({
      id: UUID.UUID(),
      image: this.model.image,
      titre: this.model.titre,
      contenu: this.model.contenu
    }).subscribe(data => {
      if (data) {


        this.notificationService.ajouter({
          id: UUID.UUID(),
          lien: 'actualite',
          objet: data.titre,
          image: data.image,
          recepteur: this.utilisateur,
          vu: 0
        }).subscribe();
        window.alert("actualité a été ajouté avec succès ");

        this.router.navigate(['actualite']);

      }
    });
  }

  ngOnInit() {


  }


}
