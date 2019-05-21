import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {AbstractControl, FormBuilder, FormControl, FormGroup, Validators} from '@angular/forms';
import {UtilisateurService} from '../../../services/utilisateur/utilisateur.service';

@Component({
  selector: 'app-parametre',
  templateUrl: './parametre.component.html',
  styleUrls: ['./parametre.component.css']
})
export class ParametreComponent implements OnInit {

  utilisateur = JSON.parse(localStorage.getItem('currentUser'))[1];
  postForm: FormGroup;
  error = false;
  error1 = false;

  constructor(
    private router: Router, private formBuilder: FormBuilder,
    private http: HttpClient,
    private utilisateurService: UtilisateurService
  ) {
  }


  modifierpassword() {
    if (this.postForm.controls.nouveau.value === this.postForm.controls.confirmer.value ) {
      this.error1 = false;

      if (this.postForm.controls.actuel.value === this.utilisateur.password) {
        this.error = false;

        this.utilisateur.password = this.postForm.controls.confirmer.value;
        this.utilisateurService.modifier(this.utilisateur).subscribe(data => {

          const val = JSON.parse(localStorage.getItem('currentUser'));
          val[1] = this.utilisateur;
          localStorage.setItem('currentUser', JSON.stringify(val));
          localStorage.removeItem('currentUser');

          this.router.navigate(['login']);
        });
      } else {
        this.error = true;
      }

    } else {

      this.error1 = true;

    }


  }


  get actuel() {
    return this.postForm.get('actuel');
  }

  get nouveau() {
    return this.postForm.get('nouveau');
  }

  get confirmer() {
    return this.postForm.get('confirmer');
  }


  ngOnInit() {
    this.postForm = this.formBuilder.group({
        actuel: [null, [Validators.required]],
        nouveau: [null, [Validators.required, Validators.minLength(5)]],
        confirmer: [null, [Validators.required]]
      });
  }

  passwordMatchValidator(frm: FormGroup) {
    return frm.controls.nouveau.value === frm.controls.confirmer.value ? null : {mismatch: true};
  }

}
