import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient, HttpRequest} from '@angular/common/http';
import {SecuriteService} from '../../../../services/securite/securite.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];

  constructor(private securiteService: SecuriteService,
              private router: Router,
              private http: HttpClient) {
  }


  logout(request: HttpRequest<any>) {
    localStorage.removeItem('currentUser');
  }


  ngOnInit() {
  }

}
