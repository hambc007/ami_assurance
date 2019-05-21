import { Injectable } from '@angular/core';
import {Actualite} from '../../model/actualite';
import {environment} from '../../config/conf';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ActualiteService {

  constructor(private http: HttpClient) {}

  private actualiteUrl = environment.URL + 'api/actualite/';


  public ajouter(actualite) {
    return this.http.post<Actualite>(this.actualiteUrl + 'ajouter/' , actualite);
  }
  public actualite(id) {
    return this.http.get<Actualite>(this.actualiteUrl + id);
  }
  public getActualites() {
    return this.http.get<Actualite[]>(this.actualiteUrl);
  }

  public supprimer(id) {
    return this.http.delete(this.actualiteUrl + 'supprimer/' + id);
  }

}
