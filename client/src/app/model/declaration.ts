import {Utilisateur} from './utilisateur';
import {Contrat} from './contrat';
import {Resultat} from './resultat'
export class Declaration {
  id: String;
  contenu: String;
  titre: String;
  client: Utilisateur;
  contrat: Contrat;
  image: String;
  date: Date;
  traiter: number;

}
