import { Component, OnInit } from '@angular/core';
import {HttpRequest} from '@angular/common/http';
import {ReclamationService} from '../../../../services/reclamation/reclamation.service';
import {Reclamation} from '../../../../model/reclamation';
import {Actualite} from '../../../../model/actualite';
import {DeclarationService} from '../../../../services/declaration/declaration.service';
import {Declaration} from '../../../../model/declaration';
import {Role} from '../../../../model/role';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  role = Role ;
  reclamation: Reclamation[];
  declaration: Declaration[];
  reclamationfilter: any = {traiter: 0};
  declarationfilter: any = {traiter: 0};


  logout(request: HttpRequest<any>) {
    localStorage.removeItem('currentUser');
  }


  constructor(private reclamationService: ReclamationService,
              private declarationService: DeclarationService) { }

  ngOnInit() {
    this.reclamationService.list().subscribe(data => {
      this.reclamation = data;
    });
    this.role =this.utilisateur.role ;

    this.declarationService.list().subscribe(da => {
      this.declaration = da;
    });
  }

}
