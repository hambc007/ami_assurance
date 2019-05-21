import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../config/conf';
import {Observable} from 'rxjs';
import {Utilisateur} from '../../model/utilisateur';

@Injectable({
  providedIn: 'root'
})
export class UtilisateurService {

  constructor(private http: HttpClient) {}

  private utilisateurUrl = environment.URL + 'api/utilisateur/';


  public modifier(utilisateur): Observable<Object> {
    return this.http.put(this.utilisateurUrl + 'modifier/' + utilisateur.id, utilisateur);
  }

  public list() {
    return this.http.get<Utilisateur[]>(this.utilisateurUrl);
  }

  public ajouter(utilisateur) {
    return this.http.post(this.utilisateurUrl + 'ajouter/' , utilisateur);
  }

  public supprimer(utilisateur) {
    return this.http.delete(this.utilisateurUrl + 'supprimer/' + utilisateur.id);
  }
}
