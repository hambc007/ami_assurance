import { Injectable } from '@angular/core';
import {Observable} from 'rxjs';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../config/conf';

@Injectable({
  providedIn: 'root'
})
export class SecuriteService {

  constructor(private http: HttpClient) {}



  login(email: string, password: string) {
    return this.http.post<any>(environment.URL + 'login', { 'email' : email, 'password': password });
  }



}
