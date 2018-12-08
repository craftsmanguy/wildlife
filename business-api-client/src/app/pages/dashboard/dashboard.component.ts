import { Component, OnInit } from '@angular/core';
import { User, UserAction, PetMinimal } from '../../profil/model';
import { UserService } from '../../services/user.service';
import { PetService } from '../../services/pet.service';
import { CampaignService } from '../../services/campaign.service';

import { first } from 'rxjs/operators';

import { Pet } from '../../pet/model';
import { Campaign } from '../../campaign/model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  profil: User;
  actionPet: UserAction;
  pet: Pet;
  campaign: Campaign;

  constructor(
    private userService: UserService,
    private petService: PetService,
    private campaignService: CampaignService,
  ) { }

  ngOnInit() {
    this.getCurrent();
  };

  getCurrent() {
    this.userService.getCurrent().subscribe(profil => { this.profil = profil });
  };

  onPetAction(action: UserAction) {
    this.actionPet = action;
    if (action.action === 'VIEW_PET' || action.action === 'UPDATE_PET') {
      this.getPetById(action.id);
    }
    if (action.action === 'VIEW_CAMPAIGN' || action.action === 'UPDATE_CAMPAIGN') {
      this.getCampaignById(action.id);
    }
  };

  getPetById(id: string) {
    this.petService.getById(id).subscribe(pet => this.pet = pet);
  };

  getCampaignById(id: string) {
    this.campaignService.getById(id).subscribe(campaign => this.campaign = campaign);
  };

  onPetToAdd(result: Pet) {
    this.petService.save(result)
      .pipe(first())
      .subscribe(
      data => {
        this.profil.pets.push({
          functionalIdentifier: data.functionalIdentifier,
          name: data.name
        });
        this.actionPet = undefined;
      });
  };

  onCampaignToAdd(result: Campaign) {
    this.campaignService.save(result)
      .pipe(first())
      .subscribe(
      data => {
        this.profil.adverts.push({
          functionalIdentifier: data.functionalIdentifier,
          title: data.title
        });
        this.actionPet = undefined;
      });
  };

}
