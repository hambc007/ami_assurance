import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../config/conf';
import {Actualite} from '../../model/actualite';
import {Agence} from '../../model/agence';

@Injectable({
  providedIn: 'root'
})
export class AgenceService {

  constructor(private http: HttpClient) {}

  private agenceUrl = environment.URL + 'api/agence/';


  public getAgences() {
    return this.http.get<Agence[]>(this.agenceUrl);
  }

}
