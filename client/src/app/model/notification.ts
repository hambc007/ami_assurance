import {Utilisateur} from './utilisateur';

export class Notification {
  id: String;
  date: Date;
  lien: String;
  objet: String;
  recepteur: Utilisateur;
  image: Blob;
  vu: number;
}
