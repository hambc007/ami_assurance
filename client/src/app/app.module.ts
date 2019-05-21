import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {LoginComponent} from './components/utilisateur/login/login.component';
import {ActualiteComponent} from './components/utilisateur/actualite/actualite.component';
import {HeaderComponent} from './components/utilisateur/common/header/header.component';
import {MenuComponent} from './components/utilisateur/common/menu/menu.component';
import {FooterComponent} from './components/utilisateur/common/footer/footer.component';
import {AgenceComponent} from './components/utilisateur/agence/agence.component';
import {ProfileComponent} from './components/utilisateur/profile/profile.component';
import {ContratComponent} from './components/client/contrat/contrat.component';
import {ParametreComponent} from './components/utilisateur/parametre/parametre.component';
import {DetailcontratComponent} from './components/client/contrat/detailcontrat/detailcontrat.component';
import {NotificationComponent} from './components/utilisateur/common/header/notification/notification.component';
import {NotificationsComponent} from './components/utilisateur/notifications/notifications.component';
import {ErrorComponent} from './components/utilisateur/error/error.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {AppRoutingModule} from './app-routing.module';
import {FilterPipeModule} from 'ngx-filter-pipe';
import {JwtInterceptor} from './config/jwt.interceptor';
import {ErrorInterceptor} from './config/error.interceptor';
import {ActualitesComponent} from './components/administrateur/actualites/actualites.component';
import {AjouterComponent} from './components/administrateur/client/ajouter/ajouter.component';
import {ListComponent} from './components/administrateur/client/list/list.component';
import {TimeAgoPipe} from 'time-ago-pipe';
import {RechercheComponent} from './components/administrateur/contrat/recherche/recherche.component';
import { AjoutercontratComponent } from './components/administrateur/contrat/ajoutercontrat/ajoutercontrat.component';
import { ReclamationComponent } from './components/client/reclamation/reclamation.component';
import { ListreclamationComponent } from './components/administrateur/listreclamation/listreclamation.component';
import { VoirreclamationComponent } from './components/administrateur/voirreclamation/voirreclamation.component';
import { DeclarationComponent } from './components/client/declaration/declaration.component';
import { ListdeclarationComponent } from './components/administrateur/declaration/listdeclaration/listdeclaration.component';
import { AjouterresultatComponent } from './components/administrateur/declaration/ajouterresultat/ajouterresultat.component';
import { HistoriqueComponent } from './components/historique/historique.component';
import { UpdatesComponent } from './components/administrateur/updates/updates.component';
import { VoirhistoriqueComponent } from './components/historique/voirhistorique/voirhistorique.component';
import { ActualiteclientComponent } from './components/client/actualiteclient/actualiteclient.component';
import { VoiractualiteComponent } from './components/client/actualiteclient/voiractualite/voiractualite.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    ActualiteComponent,
    HeaderComponent,
    MenuComponent,
    FooterComponent,
    AgenceComponent,
    ProfileComponent,
    ParametreComponent,
    ContratComponent,
    DetailcontratComponent,
    NotificationComponent,
    NotificationsComponent,
    ErrorComponent,
    ActualitesComponent,
    AjouterComponent,
    ListComponent,
    TimeAgoPipe,
    RechercheComponent,
    AjoutercontratComponent,
    ReclamationComponent,
    ListreclamationComponent,
    VoirreclamationComponent,
    DeclarationComponent,
    ListdeclarationComponent,
    AjouterresultatComponent,
    HistoriqueComponent,
    UpdatesComponent,
    VoirhistoriqueComponent,
    ActualiteclientComponent,
    VoiractualiteComponent,

  ],
  imports: [
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FilterPipeModule,
    FormsModule],
  providers: [{provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true}],
  bootstrap: [AppComponent]
})
export class AppModule {
}
