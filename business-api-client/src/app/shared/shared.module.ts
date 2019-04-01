import { CommonModule } from '@angular/common';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { ErrorResponseInterceptor } from './interceptors/error.response.interceptor';
import { CrossDomainInterceptor } from './interceptors/request.interceptor';
import { DefaultCardComponent } from './containers/default-card/default-card.component';
import { MaterialModule } from 'app/app.material.module';
import { DeleteComponent } from './components/buttons/delete/delete.component';
import { AlertComponent } from './components/alert/alert.component';
import { DialogComponent } from './components/dialog/dialog.component';
import { FilterComponent } from './components/filter/filter.component';
import { QuickSearchComponent } from './components/quick-search/quick-search.component';
import { SearchComponent } from './components/search/search.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';


@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ],
  declarations: [AlertComponent, DefaultCardComponent, DeleteComponent, DialogComponent,
    FilterComponent, QuickSearchComponent, SearchComponent],
  providers: [
    { provide: HTTP_INTERCEPTORS, useClass: ErrorResponseInterceptor, multi: true },
    { provide: HTTP_INTERCEPTORS, useClass: CrossDomainInterceptor, multi: true }
  ],
  exports: [AlertComponent, DefaultCardComponent, DeleteComponent, DialogComponent,
    FilterComponent, QuickSearchComponent, SearchComponent],
  entryComponents: [DialogComponent]
})
export class SharedModule { }
