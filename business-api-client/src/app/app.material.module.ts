import { NgModule } from '@angular/core';


import { MatIconModule, MatTableModule } from '@angular/material';
import { MatSelectModule } from '@angular/material/select';
import { MatCheckboxModule } from '@angular/material/checkbox';

import { MatAutocompleteModule } from '@angular/material/autocomplete';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';
import { MatCardModule } from '@angular/material/card';
import { MatRadioModule } from '@angular/material/radio';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatNativeDateModule, DateAdapter, MAT_DATE_FORMATS } from '@angular/material';
import { MatTreeModule } from '@angular/material/tree';
import { MatSnackBarModule } from '@angular/material/snack-bar';
import { MatBadgeModule } from '@angular/material/badge';
import { MatExpansionModule } from '@angular/material/expansion';
import { MatMenuModule } from '@angular/material/menu';
import { MatDividerModule } from '@angular/material/divider';

import { MatButtonModule, MatToolbarModule, MatProgressSpinnerModule } from '@angular/material';
import {MatDialogModule} from '@angular/material/dialog';



@NgModule({
    imports: [MatAutocompleteModule,
        MatFormFieldModule,
        MatSelectModule,
        MatIconModule,
        MatInputModule,
        MatCheckboxModule,
        MatSlideToggleModule,
        MatCardModule,
        MatRadioModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatTreeModule,
        MatSnackBarModule,
        MatBadgeModule,
        MatExpansionModule,
        MatMenuModule,
        MatButtonModule,
        MatDividerModule,
        MatToolbarModule,
        MatProgressSpinnerModule,
        MatDatepickerModule,
        MatDialogModule],

    exports: [MatAutocompleteModule,
        MatFormFieldModule,
        MatSelectModule,
        MatIconModule,
        MatInputModule,
        MatCheckboxModule,
        MatSlideToggleModule,
        MatCardModule,
        MatRadioModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatTreeModule,
        MatSnackBarModule,
        MatBadgeModule,
        MatExpansionModule,
        MatMenuModule,
        MatButtonModule,
        MatDividerModule,
        MatToolbarModule,
        MatProgressSpinnerModule,
        MatDatepickerModule,
        MatDialogModule]
})


export class MaterialModule { }
