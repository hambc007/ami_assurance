import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../config/conf';
import {Observable} from 'rxjs';
import {Declaration} from '../../model/declaration';

@Injectable({
  providedIn: 'root'
})
export class DeclarationService {

  constructor(private http: HttpClient) {
  }

  private declarationUrl = environment.URL + 'api/declaration/';


  public modifier(id): Observable<Object> {
    return this.http.put(this.declarationUrl + 'modifier/', id);
  }

  public list() {
    return this.http.get<Declaration[]>(this.declarationUrl);
  }

  public declaration(id) {
    return this.http.get<Declaration>(this.declarationUrl + id);
  }

  public ajouter(declaration) {
    return this.http.post<Declaration>(this.declarationUrl + 'ajouter/', declaration);
  }

  public supprimer(declaration) {
    return this.http.delete(this.declarationUrl + 'supprimer/' + declaration.id);
  }

}
