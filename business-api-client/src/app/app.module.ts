import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { ErrorResponseInterceptor } from './interceptors/error.response.interceptor';
import { CrossDomainInterceptor } from './interceptors/request.interceptor';

import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ApplicationRef, ErrorHandler } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';


import { AuthGuard } from './interceptors/auth.guard';

import { CampaignService } from './services/campaign.service';
import { ConnectionService } from './services/connection.service';
import { AlertService } from './alert/alert.service';
import { UserService } from './services/user.service';
import { PetService } from './services/pet.service';
import { AdminService } from './services/admin.service';

import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NgxPopperModule } from 'ngx-popper';

import { MaterialModule } from './imports/app.material.module';

import 'hammerjs';

import { AppComponent } from './app.component';

import { CampaignComponent } from './campaign/campaign.component';
import { AddCampaignComponent } from './campaign/add-campaign/add-campaign.component';
import { ViewCampaignComponent } from './campaign/view-campaign/view-campaign.component';
import { UpdateCampaignComponent } from './campaign/update-campaign/update-campaign.component';
import { ListCampaignComponent } from './campaign/list-campaign/list-campaign.component';

import { PetComponent } from './pet/pet.component';
import { AddPetComponent } from './pet/add-pet/add-pet.component';
import { ViewPetComponent } from './pet/view-pet/view-pet.component';
import { ListPetComponent } from './pet/list-pet/list-pet.component';
import { UpdatePetComponent } from './pet/update-pet/update-pet.component';


import { FrameComponent } from './frame/frame.component';
import { HomeComponent } from './home/home.component';
import { PageComponent } from './page/page.component';

import { NavComponent } from './nav/nav.component';
import { ConnectionComponent } from './connection/connection.component';
import { AlertComponent } from './alert/alert.component';

import { RegisterComponent } from './register/register.component';
import { ProfilComponent } from './profil/profil.component';

import { NotFoundComponent } from './notfound/notfound.component';


@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    NavComponent,
    ConnectionComponent,
    AlertComponent,
    RegisterComponent,
    ProfilComponent,

    ListCampaignComponent,
    CampaignComponent,
    AddCampaignComponent,
    ViewCampaignComponent,
    UpdateCampaignComponent,

    PetComponent,
    ListPetComponent,
    ViewPetComponent,
    AddPetComponent,
    UpdatePetComponent,

    FrameComponent,
    HomeComponent,
    PageComponent

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
  ],
  providers: [
    AuthGuard,
    AlertService,
    CampaignService,
    ConnectionService,
    UserService,
    PetService,
    AdminService,
    { provide: HTTP_INTERCEPTORS, useClass: ErrorResponseInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: CrossDomainInterceptor, multi: true }


  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
  }

}
