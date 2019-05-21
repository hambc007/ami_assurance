import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ActualiteComponent} from './components/utilisateur/actualite/actualite.component';
import {AgenceComponent} from './components/utilisateur/agence/agence.component';
import {AuthGuard} from './config/securite/auth.guard';
import {SessionGuard} from './config/securite/session.guard';
import {ProfileComponent} from './components/utilisateur/profile/profile.component';
import {LoginComponent} from './components/utilisateur/login/login.component';
import {ParametreComponent} from './components/utilisateur/parametre/parametre.component';
import {ContratComponent} from './components/client/contrat/contrat.component';
import {ErrorComponent} from './components/utilisateur/error/error.component';
import {DetailcontratComponent} from './components/client/contrat/detailcontrat/detailcontrat.component';
import {NotificationsComponent} from './components/utilisateur/notifications/notifications.component';
import {ActualitesComponent} from './components/administrateur/actualites/actualites.component';
import {AjouterComponent} from './components/administrateur/client/ajouter/ajouter.component';
import {ListComponent} from './components/administrateur/client/list/list.component';
import {RechercheComponent} from './components/administrateur/contrat/recherche/recherche.component';
import {AjoutercontratComponent} from './components/administrateur/contrat/ajoutercontrat/ajoutercontrat.component';
import {ReclamationComponent} from './components/client/reclamation/reclamation.component';
import {ListreclamationComponent} from './components/administrateur/listreclamation/listreclamation.component';
import {VoirreclamationComponent} from './components/administrateur/voirreclamation/voirreclamation.component';
import {DeclarationComponent} from './components/client/declaration/declaration.component';
import {AjouterresultatComponent} from './components/administrateur/declaration/ajouterresultat/ajouterresultat.component';
import {ListdeclarationComponent} from './components/administrateur/declaration/listdeclaration/listdeclaration.component';
import {HistoriqueComponent} from './components/historique/historique.component';
import {UpdatesComponent} from './components/administrateur/updates/updates.component';
import {VoirhistoriqueComponent} from './components/historique/voirhistorique/voirhistorique.component';
import {ActualiteclientComponent} from './components/client/actualiteclient/actualiteclient.component';
import {VoiractualiteComponent} from './components/client/actualiteclient/voiractualite/voiractualite.component';


const routes: Routes = [
  // Pour les clients
  {path: 'contrat', component: ContratComponent, canActivate: [AuthGuard]},
  {path: 'reclamer', component: ReclamationComponent, canActivate: [AuthGuard]},
  {path: 'declaration/ajouter', component: DeclarationComponent, canActivate: [AuthGuard]},
  {path: 'historique', component: HistoriqueComponent, canActivate: [AuthGuard]},
  {path: 'voirhistorique/:id', component: VoirhistoriqueComponent, canActivate: [AuthGuard]},
  {path: 'actualiteclient', component: ActualiteclientComponent, canActivate: [AuthGuard]},
  {path: 'voiractualite/:id', pathMatch: 'full', component: VoiractualiteComponent, canActivate: [AuthGuard]},


  // Pour les administrateurs
  {path: 'actualite/ajouter', component: ActualitesComponent, canActivate: [AuthGuard]},
  {path: 'client/list', component: ListComponent, canActivate: [AuthGuard]},
  {path: 'client/ajouter', component: AjouterComponent, canActivate: [AuthGuard]},
  {path: 'contrat/ajouter', component: AjoutercontratComponent, canActivate: [AuthGuard]},
  {path: 'contrat/recherche', component: RechercheComponent, canActivate: [AuthGuard]},
  {path: 'reclamation/list', component: ListreclamationComponent, canActivate: [AuthGuard]},
  {path: 'reclamation/voir/:id', pathMatch: 'full', component: VoirreclamationComponent, canActivate: [AuthGuard]},
  {path: 'declaration/list', component: ListdeclarationComponent, canActivate: [AuthGuard]},
  {path: 'declaration/resultat/:id', pathMatch: 'full',  component: AjouterresultatComponent, canActivate: [AuthGuard]},
  {path: 'update', component: UpdatesComponent, canActivate: [AuthGuard]},
  // toutes les utilisateur
  {path: 'login', component: LoginComponent, canActivate: [SessionGuard]},

  {path: 'actualite', component: ActualiteComponent, canActivate: [AuthGuard]},
  {path: 'agence', component: AgenceComponent, canActivate: [AuthGuard]},
  {path: 'profile', component: ProfileComponent, canActivate: [AuthGuard]},
  {path: 'parametre', component: ParametreComponent, canActivate: [AuthGuard]},
  {path: 'error/:status/:message/:text', pathMatch: 'full', component: ErrorComponent, canActivate: [AuthGuard]},
  {path: 'notification', component: NotificationsComponent, canActivate: [AuthGuard]},
  {path: 'detail/contrat/:id', pathMatch: 'full', component: DetailcontratComponent, canActivate: [AuthGuard]},
  {path: '**', redirectTo: 'login'}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
