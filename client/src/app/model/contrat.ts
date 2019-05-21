import {Utilisateur} from './utilisateur';
import {Agence} from './agence';

export class Contrat {

    id: String;
    numero_serie: String;
    type: String;
    date_creation: Date;
    date_debut: Date;
    date_fin: Date;
    client: Utilisateur;
    agence: Agence;
    status: number;
    montant: number;
    description: String;


}
