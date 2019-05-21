import {Role} from './role';

export class Utilisateur {

  id: String;
  cin: String;
  nom: String;
  prenom: String;
  email: String;
  password: String;
  adresse: String;
  datenaissance: Date;
  telephone: String;
  image: Blob;
  role: Role;



}
