import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule } from 'app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RegisterComponent } from './containers/register/register.component';
import { MaterialModule } from 'app/app.material.module';
import { InscribeComponent } from './components/inscribe/inscribe.component';
import { AppRoutingModule } from 'app/app-routing.module';
import { RegisterService } from './services/register.service';
import { ConnectionService } from './services/connection.service';
import { LoginComponent } from './containers/login/login.component';
import { ProfilComponent } from './containers/profil/profil.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  declarations: [InscribeComponent, RegisterComponent, LoginComponent, ProfilComponent],
  exports: [RegisterComponent, LoginComponent, ProfilComponent],
  providers: [RegisterService, ConnectionService]
})
export class UserModule { }
