import { NotFoundComponent } from './_notfound/notfound.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AdvertsComponent } from './adverts/adverts.component';
import { AdvertDetailComponent } from './advert-detail/advert-detail.component';
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
    path: 'tests',
    component: CampaignComponent
  },
  {
    path: 'campaigns',
    component: AdvertsComponent
  },
  {
    path: 'campaigns/:id',
    component: AdvertDetailComponent
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
