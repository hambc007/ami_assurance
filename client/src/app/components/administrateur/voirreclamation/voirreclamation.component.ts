import { Component, OnInit } from '@angular/core';
import {Reclamation} from '../../../model/reclamation';
import {ReclamationService} from '../../../services/reclamation/reclamation.service';
import {ActivatedRoute, Router} from '@angular/router';
import {NotificationService} from '../../../services/notification/notification.service';
import {UUID} from 'angular2-uuid';

@Component({
  selector: 'app-voirreclamation',
  templateUrl: './voirreclamation.component.html',
  styleUrls: ['./voirreclamation.component.css']
})
export class VoirreclamationComponent implements OnInit {

  constructor(private reclamationService: ReclamationService,
              private notificationService: NotificationService,
              private router: Router,
              private route: ActivatedRoute) {
  }

  reclamation: Reclamation;
    model: any = {};
  id = this.route.snapshot.params.id;

  modifier() {
    this.reclamationService.modifier(this.id).subscribe(data => {
      window.alert("reclamation a éte traitée");

      this.notificationService.ajouter({
        id: UUID.UUID(),
        lien: 'actualite',
        objet: 'Votre réclamation était traitée ',
        image: null,
        recepteur: this.reclamation.client,
        vu: 0
      }).subscribe();

      this.router.navigate(['/reclamation/list']);

    });
  }

  ngOnInit() {
    this.reclamationService.reclamation(this.id)
      .subscribe(data => {
        this.reclamation = data;
      });
  }

}
