import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';


import { RegisterComponent } from './register/register.component';
import { MaterialModule } from '../../app.material.module';

import { RegisterService } from './services/register.service';


@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
  ],
  declarations: [
    RegisterComponent
  ],
  providers: [RegisterService],
  exports: [RegisterComponent]
})
export class InscriptionWildlifeModule { }
