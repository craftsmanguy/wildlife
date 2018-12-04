import { Component, OnInit } from '@angular/core';
import { UserForPetAction, PetMinimal } from '../../profil/model';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  actionPet: UserForPetAction;
  addPetSucceed: PetMinimal;
  updatePetSucceed: PetMinimal;

  actionCampaign: string;
  addCampaignSucceed: any;

  constructor() { }

  ngOnInit() {
  };

  onAddPetAction(action: UserForPetAction) {
    this.actionPet = action;
  };

  onViewPetByIdAction(action: UserForPetAction) {
    this.actionPet = action;
  };

  onUpdatePetByIdAction(action: UserForPetAction) {
    this.actionPet = action;
  }

  onAddPetActionSucceed(result: PetMinimal) {
    this.addPetSucceed = result;
  };

  onAddCampaignAction(action: string) {
    this.actionCampaign = action;
  };

  onAddCampaignActionSucceed(result: any) {
    this.addCampaignSucceed = result;
  };

}
