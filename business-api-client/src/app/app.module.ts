import { HttpClientModule } from '@angular/common/http';import {BrowserModule} from '@angular/platform-browser';
import {NgModule, ApplicationRef, ErrorHandler} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


import {AppRoutingModule} from './app-routing.module';
import {NotFoundComponent} from './_notfound/notfound.component';

import {AppComponent} from './app.component';
import {AdvertsService} from './adverts/adverts.service';
import {AdvertsComponent} from './adverts/adverts.component';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import {NgxPopperModule} from 'ngx-popper';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NavComponent} from './nav/nav.component';

@NgModule({
  declarations: [
    AppComponent,
    AdvertsComponent,
    NotFoundComponent,
    NavComponent,

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
  providers: [AdvertsService],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
  }

}
