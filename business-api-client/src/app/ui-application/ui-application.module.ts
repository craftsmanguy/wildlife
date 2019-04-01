import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { UserInterfaceComponent } from './containers/user-interface/user-interface.component';
import { NavComponent } from './components/nav/nav.component';
import { MaterialModule } from 'app/app.material.module';
import { AppRoutingModule } from 'app/app-routing.module';

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    AppRoutingModule
  ],
  declarations: [HeaderComponent, FooterComponent, UserInterfaceComponent, NavComponent],
  exports: [HeaderComponent, FooterComponent, UserInterfaceComponent, NavComponent]
})
export class UiApplicationModule { }
