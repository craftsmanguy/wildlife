import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PageInscriptionComponent } from './presenter/page-inscription/page-inscription.component';
import { PageConnectionComponent } from './presenter/page-connection/page-connection.component';
import { DashboardComponent } from './presenter/dashboard/dashboard.component';
import { VisibilityComponent } from './presenter/visibility/visibility.component';
import { HomeComponent } from './presenter/home/home.component';
import { NotFoundComponent } from './presenter/notfound/notfound.component';




const routes: Routes = [
  {
    path: '404',
    component: NotFoundComponent
  },
  {
    path: 'login',
    component: PageConnectionComponent
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
    component: PageInscriptionComponent
  },
  {
    path: 'campaigns',
    children: [
      { path: '', component: VisibilityComponent },
      { path: ':id', component: VisibilityComponent }
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
