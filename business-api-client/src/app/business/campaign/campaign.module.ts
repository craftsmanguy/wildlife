import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MaterialModule } from 'app/app.material.module';
import { SharedModule } from 'app/shared/shared.module';
import { CampaignFormComponent } from './components/campaign-form/campaign-form.component';
import { AddCampaignComponent } from './containers/add-campaign/add-campaign.component';
import { UpdateCampaignComponent } from './containers/update-campaign/update-campaign.component';
import { CampaignService } from './services/campaign.service';
import { ListCampaignComponent } from './containers/list-campaign/list-campaign.component';
import { QuickViewCampaignComponent } from './containers/quick-view-campaign/quick-view-campaign.component';
import { ViewCampaignComponent } from './containers/view-campaign/view-campaign.component';

@NgModule({
  imports: [
    CommonModule,
    MaterialModule,
    SharedModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  declarations: [AddCampaignComponent, UpdateCampaignComponent, CampaignFormComponent, ListCampaignComponent,
    QuickViewCampaignComponent, ViewCampaignComponent],
  exports: [AddCampaignComponent, UpdateCampaignComponent, ListCampaignComponent, QuickViewCampaignComponent,
    ViewCampaignComponent],
  providers: [CampaignService],
  entryComponents: [ViewCampaignComponent],
})
export class CampaignModule { }



