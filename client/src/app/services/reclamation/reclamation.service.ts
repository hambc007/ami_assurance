import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../config/conf';
import {Observable} from 'rxjs';
import {Reclamation} from '../../model/reclamation';

@Injectable({
  providedIn: 'root'
})
export class ReclamationService {

  constructor(private http: HttpClient) {
  }

  private reclamationUrl = environment.URL + 'api/reclamation/';


  public modifier(id): Observable<Object> {
    return this.http.put(this.reclamationUrl + 'modifier/', id);
  }

  public list() {
    return this.http.get<Reclamation[]>(this.reclamationUrl);
  }

  public reclamation(id) {
    return this.http.get<Reclamation>(this.reclamationUrl + id);
  }

  public ajouter(reclamation) {
    return this.http.post(this.reclamationUrl + 'ajouter/', reclamation);
  }

  public supprimer(reclamation) {
    return this.http.delete(this.reclamationUrl + 'supprimer/' + reclamation.id);
  }

}
