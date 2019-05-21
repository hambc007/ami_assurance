import { Injectable } from '@angular/core';
import {environment} from '../../config/conf';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Declaration} from '../../model/declaration';
import {Resultat} from '../../model/resultat';

@Injectable({
  providedIn: 'root'
})
export class ResultatService {
constructor(private http: HttpClient) {
}
private resultatUrl = environment.URL + 'api/resultat/';

public modifier(id): Observable<Object> {
  return this.http.put(this.resultatUrl + 'modifier/', id);
}

public list() {
  return this.http.get<Resultat[]>(this.resultatUrl);
}

public resultat(id) {
  return this.http.get<Resultat>(this.resultatUrl + id);
}

public ajouter(resultat) {
  return this.http.post(this.resultatUrl + 'ajouter/', resultat);
}

public supprimer(resultat) {
  return this.http.delete(this.resultatUrl + 'supprimer/' + resultat.id);
}
}
