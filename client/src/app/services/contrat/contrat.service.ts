import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../config/conf';
import {Contrat} from '../../model/contrat';

@Injectable({
  providedIn: 'root'
})
export class ContratService {

  constructor(private http: HttpClient) {}

  private contratUrl = environment.URL + 'api/contrat/';


  public getContrats() {
    return this.http.get<Contrat[]>(this.contratUrl);
  }


  public getContrat(id) {
    return this.http.get<Contrat>(this.contratUrl + id);
  }


  public ajouter(contrat) {
    return this.http.post<Contrat>(this.contratUrl + 'ajouter/' , contrat);
  }

}
