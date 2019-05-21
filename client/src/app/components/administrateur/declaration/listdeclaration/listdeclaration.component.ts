import { Component, OnInit } from '@angular/core';
import {Utilisateur} from '../../../../model/utilisateur';
import {UtilisateurService} from '../../../../services/utilisateur/utilisateur.service';
import {Declaration} from '../../../../model/declaration';
import {DeclarationService} from '../../../../services/declaration/declaration.service';
@Component({
  selector: 'app-listdeclaration',
  templateUrl: './listdeclaration.component.html',
  styleUrls: ['./listdeclaration.component.css']
})
export class ListdeclarationComponent implements OnInit {
  declarations: Declaration[];

  constructor(private declarationService : DeclarationService) { }
  filter: any = {traiter: 0};

  ngOnInit() {
    this.declarationService.list()
      .subscribe(data => {
        this.declarations = data; }) ;
  }

}
