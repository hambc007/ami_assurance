import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {environment} from '../../config/conf';
import {Actualite} from '../../model/actualite';

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http: HttpClient) {}

  private notificationUrl = environment.URL + 'api/notification/';


  public getNotifications() {
    return this.http.get<Notification[]>(this.notificationUrl);
  }


  public modifier(recepteur) {
    return this.http.put(this.notificationUrl + 'modifier/' , recepteur);

  }


  public ajouter(notification) {
    return this.http.post(this.notificationUrl + 'ajouter/' , notification);

  }

}
