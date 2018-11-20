import {HttpModule} from '@angular/http';

import {BrowserModule} from '@angular/platform-browser';
import {NgModule, ApplicationRef, ErrorHandler} from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';

import {AppRoutingModule} from './app-routing.module';
import {NgXCookies} from 'ngx-cookies';

import {NotFoundComponent} from './_notfound/notfound.component';
import {LoggingService, Config} from 'loggerservice';

import {AppComponent} from './app.component';
import {AdvertsService} from './adverts/adverts.service';
import {AdvertsComponent} from './adverts/adverts.component';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import 'hammerjs';

import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import {NavComponent} from './nav/nav.component';

import {AgmCoreModule} from '@agm/core';

import {CalendarModule, SharedModule, AutoCompleteModule} from 'primeng/primeng';




@NgModule({
  declarations: [
    AppComponent,
    AdvertsComponent,
    NotFoundComponent,
    NavComponent,

  ],
  imports: [
    BrowserModule,
    HttpModule,
    FormsModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    NgbModule.forRoot(),
    CalendarModule, SharedModule, AutoCompleteModule,
    AgmCoreModule.forRoot({
      apiKey: ' AIzaSyCIOYh9OOXa_2xT6nHIPfDJVf0MJzMzlvk'
    })
  ],
  exports: [CalendarModule],
  providers: [AdvertsService, NgXCookies, Config, LoggingService],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
  }

}
