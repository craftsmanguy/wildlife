import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ApplicationRef, ErrorHandler } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { NotFoundComponent } from './_notfound/notfound.component';

import { AppComponent } from './app.component';
import { AdvertService } from './services/advert.service';
import { AdvertsComponent } from './adverts/adverts.component';

import { ConnectionService } from './services/connection.service';
import { AlertService } from './alert/alert.service';
import { UserService } from './services/user.service';
import { PetService } from './services/pet.service';



import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NgxPopperModule } from 'ngx-popper';

import { NavComponent } from './nav/nav.component';
import { ConnectionComponent } from './connection/connection.component';
import { AlertComponent } from './alert/alert.component';

import { ErrorInterceptor } from './interceptors/error.interceptor';
import { AdvertDetailComponent } from './advert-detail/advert-detail.component';
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


import 'hammerjs';
import { CampaignComponent } from './campaign/campaign.component';


@NgModule({
  declarations: [
    AppComponent,
    AdvertsComponent,
    NotFoundComponent,
    NavComponent,
    ConnectionComponent,
    AlertComponent,
    AdvertDetailComponent,
    RegisterComponent,
    ProfilComponent,
    PetComponent,
    CampaignComponent,

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
  ],
  providers: [
    AlertService,
    AdvertService,
    ConnectionService,
    UserService,
    PetService,
    MatDatepickerModule,
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
  }

}
