import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {SecuriteService} from '../../../services/securite/securite.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private securiteService: SecuriteService,
              private router: Router,
              private http: HttpClient) {
  }

  model: any = {};
  error = false;

  login() {
    this.securiteService.login(this.model.username, this.model.password)
      .subscribe(res => {
        if (res && res.data[0]) {

          localStorage.setItem('currentUser', JSON.stringify(res.data));
          this.router.navigate(['actualiteclient']);

        } else {
          this.error = true;
        }
      });
  }

  ngOnInit() {


  }

}
