import {Utilisateur} from './utilisateur'
import {Contrat} from './contrat'

export class Resultat {
id :String;
date :Date;
etat :String;
resultat :String;
montant  :number ;
description :String ;
client :Utilisateur ;
contrat :Contrat
}
