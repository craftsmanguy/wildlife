import { Component, OnInit } from '@angular/core';
import { UserForPetAction } from '../profil/model';


@Component({
  selector: 'app-page',
  templateUrl: './page.component.html',
  styleUrls: ['./page.component.css']
})
export class PageComponent implements OnInit {

  actionPet: string;
  addPetSucceed: any;
  actionViewPetById: UserForPetAction;

  actionCampaign: string;
  addCampaignSucceed: any;

  constructor() { }

  ngOnInit() {
  };

  onAddPetAction(action: string) {
    this.actionPet = action;
  };

  onViewPetByIdAction(action: UserForPetAction) {
    this.actionViewPetById = action;
  };

  onAddPetActionSucceed(result: any) {
    this.addPetSucceed = result;
  };

  onAddCampaignAction(action: string) {
    this.actionCampaign = action;
  };

  onAddCampaignActionSucceed(result: any) {
    this.addCampaignSucceed = result;
  };

}
