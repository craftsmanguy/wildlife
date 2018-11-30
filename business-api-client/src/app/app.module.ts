import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ApplicationRef, ErrorHandler } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { NotFoundComponent } from './_notfound/notfound.component';

import { AppComponent } from './app.component';

import {AuthGuard} from './interceptors/auth.guard';

import { AdvertService } from './services/advert.service';
import { AdvertsComponent } from './adverts/adverts.component';
import { ConnectionService } from './services/connection.service';
import { AlertService } from './alert/alert.service';
import { UserService } from './services/user.service';
import { PetService } from './services/pet.service';
import { AdminService } from './services/admin.service';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NgxPopperModule } from 'ngx-popper';

import { NavComponent } from './nav/nav.component';
import { ConnectionComponent } from './connection/connection.component';
import { AlertComponent } from './alert/alert.component';

import { ErrorInterceptor } from './interceptors/error.interceptor';
import { RegisterComponent } from './register/register.component';
import { ProfilComponent } from './profil/profil.component';

import { MatIconModule, MatTableModule } from '@angular/material';
import { PetComponent } from './pet/pet.component';
import { MatSelectModule } from '@angular/material/select';
import { MatCheckboxModule } from '@angular/material/checkbox';

import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';

import { MatNativeDateModule, DateAdapter, MAT_DATE_FORMATS } from '@angular/material';

import {MatTreeModule} from '@angular/material/tree';
import {MatSnackBarModule} from '@angular/material/snack-bar';




import 'hammerjs';
import { CampaignComponent } from './campaign/campaign.component';
import { AddCampaignComponent } from './campaign/add-campaign/add-campaign.component';
import { ViewCampaignComponent } from './campaign/view-campaign/view-campaign.component';
import { UpdateCampaignComponent } from './campaign/update-campaign/update-campaign.component';


@NgModule({
  declarations: [
    AppComponent,
    AdvertsComponent,
    NotFoundComponent,
    NavComponent,
    ConnectionComponent,
    AlertComponent,
    RegisterComponent,
    ProfilComponent,
    PetComponent,
    CampaignComponent,
    AddCampaignComponent,
    ViewCampaignComponent,
    UpdateCampaignComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    NgxPopperModule,
    MatAutocompleteModule,
    MatFormFieldModule,
    MatSelectModule,
    MatIconModule,
    MatInputModule,
    MatCheckboxModule,
    MatSlideToggleModule,
    MatCardModule,
    MatRadioModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTreeModule,
    MatSnackBarModule
  ],
  providers: [
    AuthGuard,
    AlertService,
    AdvertService,
    ConnectionService,
    UserService,
    PetService,
    AdminService,
    MatDatepickerModule,
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
  }

}
