import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ApplicationRef, ErrorHandler } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


import { AppRoutingModule } from './app-routing.module';
import { NotFoundComponent } from './_notfound/notfound.component';

import { AppComponent } from './app.component';
import { AdvertsService } from './adverts/adverts.service';
import { AdvertsComponent } from './adverts/adverts.component';

import { ConnectionService } from './services/connection.service';
import { AlertService } from './alert/alert.service';

import { UserService } from './services/user.service';


import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { NgxPopperModule } from 'ngx-popper';

import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { NavComponent } from './nav/nav.component';
import { ConnectionComponent } from './connection/connection.component';
import { AlertComponent } from './alert/alert.component';

import { ErrorInterceptor } from './interceptors/error.interceptor';
import { AdvertDetailComponent } from './advert-detail/advert-detail.component';
import { RegisterComponent } from './register/register.component';
import { ProfilComponent } from './profil/profil.component';

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

  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    NgxPopperModule,
    NgbModule.forRoot()
  ],
  providers: [
    AlertService,
    AdvertsService,
    ConnectionService,
    UserService,
    { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true }
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
  }

}
