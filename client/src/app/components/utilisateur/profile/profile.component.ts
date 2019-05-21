import {Component, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ActivatedRoute, Router} from '@angular/router';
import {UtilisateurService} from '../../../services/utilisateur/utilisateur.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient,
    private utilisateurService: UtilisateurService
  ) {}

  utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  modifier = false;


  toggle() {
    this.modifier ? this.modifier = false : this.modifier = true;
  }

  changeimage(files) {
    const reader = new FileReader();
    reader.readAsDataURL(files[0]);
    reader.onload = (_event) => {
      this.utilisateur.image = reader.result;
    };
  }

modifiercompte() {

  this.utilisateurService.modifier(this.utilisateur).subscribe(data => {
    this.modifier = false;

    const kittens = JSON.parse(localStorage.getItem('currentUser'));
    kittens[1] = this.utilisateur;
    localStorage.setItem('currentUser', JSON.stringify(kittens));

  });

}




  ngOnInit() {
  }

}
