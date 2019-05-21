import {Utilisateur} from './utilisateur';

export class Reclamation {
  id: String;
  contenu: String;
  titre: String;
  client: Utilisateur;
  date: Date;
  traiter: number;
}
