import { NotFoundComponent } from './_notfound/notfound.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AdvertsComponent } from './adverts/adverts.component';
import { ConnectionComponent } from './connection/connection.component';
import { RegisterComponent } from './register/register.component';
import { ProfilComponent } from './profil/profil.component';
import { PetComponent } from './pet/pet.component';

import { CampaignComponent } from './campaign/campaign.component';


const routes: Routes = [
  {
    path: '404',
    component: NotFoundComponent
  },
  {
    path: 'login',
    component: ConnectionComponent
  },
  {
    path: 'profils/:id',
    component: ProfilComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'pets',
    component: PetComponent
  },
  {
    path: 'campaigns',
    children: [
      { path: '', component: CampaignComponent },
      { path: ':id', component: CampaignComponent },
  ]
  },
  {
    path: 'campaigns-old',
    component: AdvertsComponent
  },
  {
    path: '**',
    redirectTo: '404',
    pathMatch: 'full'
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
