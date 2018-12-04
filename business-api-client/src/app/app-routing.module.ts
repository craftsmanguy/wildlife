import { NotFoundComponent } from './notfound/notfound.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { ListCampaignComponent } from './campaign/list-campaign/list-campaign.component';
import { ConnectionComponent } from './connection/connection.component';
import { RegisterComponent } from './register/register.component';
import { ProfilComponent } from './profil/profil.component';

import { AuthGuard } from './interceptors/auth.guard';
import { HomeComponent } from './home/home.component';

import { CampaignComponent } from './campaign/campaign.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { InscriptionComponent } from './pages/inscription/inscription.component';


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
    path: 'home',
    component: HomeComponent
  },
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'dashboard/current',
    component: DashboardComponent
  },
  {
    path: 'profils/:id',
    component: DashboardComponent
  },
  {
    path: 'inscription',
    component: InscriptionComponent
  },
  {
    path: 'campaigns',
    children: [
      { path: '', component: CampaignComponent },
      { path: ':id', component: CampaignComponent },

    ]
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
