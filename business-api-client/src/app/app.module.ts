import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ErrorResponseInterceptor } from './interceptors/error.response.interceptor';
import { CrossDomainInterceptor } from './interceptors/request.interceptor';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ApplicationRef, ErrorHandler } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { ConnectionService } from './services/connection.service';


import { AuthGuard } from './interceptors/auth.guard';

import { CampaignService } from './services/campaign.service';
import { AlertService } from './commons/alert/alert.service';
import { UserService } from './services/user.service';
import { PetService } from './services/pet.service';
import { AdminService } from './services/admin.service';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NgxPopperModule } from 'ngx-popper';

import { MaterialModule } from './app.material.module';

import 'hammerjs';

import { AppComponent } from './app.component';

import { AddCampaignComponent } from './campaign/add-campaign/add-campaign.component';
import { ViewCampaignComponent } from './campaign/view-campaign/view-campaign.component';
import { UpdateCampaignComponent } from './campaign/update-campaign/update-campaign.component';
import { ListCampaignComponent } from './campaign/list-campaign/list-campaign.component';
import { QuickViewCampaignComponent } from './campaign/quick-view-campaign/quick-view-campaign.component';

import { AddPetComponent } from './pet/add-pet/add-pet.component';
import { ViewPetComponent } from './pet/view-pet/view-pet.component';
import { ListPetComponent } from './pet/list-pet/list-pet.component';
import { UpdatePetComponent } from './pet/update-pet/update-pet.component';

import { NavComponent } from './commons/nav/nav.component';
import { LoginComponent } from './specifics/login/login.component';
import { AlertComponent } from './commons/alert/alert.component';

import { ProfilComponent } from './profil/profil.component';

import { NotFoundComponent } from './notfound/notfound.component';
import { DeleteComponent } from './commons/delete/delete.component';
import { DialogComponent } from './commons/dialog/dialog.component';
import { SearchComponent } from './commons/search/search.component';
import { QuickSearchComponent } from './commons/quick-search/quick-search.component';
import { FilterComponent } from './commons/filter/filter.component';

import { HomeComponent } from './pages/home/home.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { InscriptionComponent } from './pages/inscription/inscription.component';
import { ConnectionComponent } from './pages/connection/connection.component';
import { VisibilityComponent } from './pages/visibility/visibility.component';

import { InscriptionWildlifeModule } from './modules/inscription-wildlife/inscription-wildlife.module';

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    NavComponent,
    LoginComponent,
    AlertComponent,
    ProfilComponent,

    ListCampaignComponent,
    AddCampaignComponent,
    ViewCampaignComponent,
    QuickViewCampaignComponent,
    UpdateCampaignComponent,

    ListPetComponent,
    ViewPetComponent,
    AddPetComponent,
    UpdatePetComponent,

    HomeComponent,
    DashboardComponent,
    DeleteComponent,
    DialogComponent,
    InscriptionComponent,
    SearchComponent,
    QuickSearchComponent,
    FilterComponent,
    ConnectionComponent,
    VisibilityComponent

  ],
  imports: [
    BrowserModule,
    CommonModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    NgxPopperModule,
    MaterialModule,
    InscriptionWildlifeModule

  ],
  providers: [
    AuthGuard,
    AlertService,
    CampaignService,
    UserService,
    PetService,
    AdminService,
    ConnectionService,
    { provide: HTTP_INTERCEPTORS, useClass: ErrorResponseInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: CrossDomainInterceptor, multi: true }


  ],
  entryComponents: [DialogComponent],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
  }

}
