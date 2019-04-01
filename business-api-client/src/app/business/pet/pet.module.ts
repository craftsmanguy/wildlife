import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PetService } from './services/pet.service';
import { AddPetComponent } from './containers/add-pet/add-pet.component';
import { ListPetComponent } from './containers/list-pet/list-pet.component';
import { UpdatePetComponent } from './containers/update-pet/update-pet.component';
import { ViewPetComponent } from './containers/view-pet/view-pet.component';
import { MaterialModule } from 'app/app.material.module';
import { SharedModule } from 'app/shared/shared.module';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  declarations: [AddPetComponent, ListPetComponent, UpdatePetComponent, ViewPetComponent],
  exports: [AddPetComponent, ListPetComponent, UpdatePetComponent, ViewPetComponent],
  providers: [PetService]
})
export class PetModule { }

