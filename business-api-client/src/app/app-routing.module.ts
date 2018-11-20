import {NotFoundComponent} from './_notfound/notfound.component';
import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {AdvertsComponent} from './adverts/adverts.component';


const routes: Routes = [
  {
    path: '404',
    component: NotFoundComponent
  },
  {
    path: 'adverts',
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
export class AppRoutingModule {}
