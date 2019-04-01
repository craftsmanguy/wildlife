import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import 'hammerjs';
import { NgxPopperModule } from 'ngx-popper';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MaterialModule } from './app.material.module';
import { CampaignModule } from './business/campaign/campaign.module';
import { PetModule } from './business/pet/pet.module';
import { UserModule } from './business/user/user.module';
import { DashboardComponent } from './presenter/dashboard/dashboard.component';
import { HomeComponent } from './presenter/home/home.component';
import { NotFoundComponent } from './presenter/notfound/notfound.component';
import { PageConnectionComponent } from './presenter/page-connection/page-connection.component';
import { PageInscriptionComponent } from './presenter/page-inscription/page-inscription.component';
import { VisibilityComponent } from './presenter/visibility/visibility.component';
import { SharedModule } from './shared/shared.module';
import { UiApplicationModule } from './ui-application/ui-application.module';


@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,

    HomeComponent,
    DashboardComponent,
    PageConnectionComponent,
    VisibilityComponent,
    PageInscriptionComponent

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
    SharedModule,
    UiApplicationModule,
    UserModule,
    CampaignModule,
    PetModule

  ],
  bootstrap: [AppComponent]
})
export class AppModule {
  constructor() {
  }

}
