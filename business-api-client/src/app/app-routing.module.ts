import { NotFoundComponent } from './pages/notfound/notfound.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { AuthGuard } from './interceptors/auth.guard';

import { HomeComponent } from './pages/home/home.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { InscriptionComponent } from './pages/inscription/inscription.component';
import { ConnectionComponent } from './pages/connection/connection.component';
import { VisibilityComponent } from './pages/visibility/visibility.component';



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
      { path: '', component: VisibilityComponent },
      { path: ':id', component: VisibilityComponent },

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
