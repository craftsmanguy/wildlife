import { Component, OnInit, Input, Output, OnChanges, SimpleChanges, EventEmitter } from '@angular/core';

import { ActivatedRoute, ParamMap } from '@angular/router';
import { Router } from '@angular/router';

import { UserService } from '../services/user.service';

import { FlatTreeControl } from '@angular/cdk/tree';


import { User, UserForPetAction } from './model';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css'],
  providers: [UserService]
})
export class ProfilComponent implements OnInit, OnChanges {

  @Output() addPetAction: EventEmitter<String> = new EventEmitter();
  @Output() addCampaignAction: EventEmitter<String> = new EventEmitter();
  @Output() viewPetByIdAction: EventEmitter<UserForPetAction> = new EventEmitter();

  @Input() petAdded: any;
  @Input() campaignAdded: any;

  isButtonPetDisabled = false;
  isButtonCampaignDisabled = false;

  profil: User;

  panelOpenState = false;

  private addAction: string;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
    private userService: UserService,
  ) {

  }

  ngOnInit() {
    this.getCurrent();
  };

  ngOnChanges(changes: SimpleChanges) {
    if (this.profil !== undefined && this.profil.pets !== undefined) {
      if (changes.petAdded !== undefined && changes.petAdded.currentValue !== undefined) {
        this.profil.pets.push(changes.petAdded.currentValue);
        this.isButtonPetDisabled = !this.isButtonPetDisabled;
        this.addPetAction.emit();
      }
    }

    if (this.profil !== undefined && this.profil.adverts !== undefined) {
      if (changes.campaignAdded !== undefined && changes.campaignAdded.currentValue !== undefined) {
        this.profil.adverts.push(changes.campaignAdded.currentValue);
        this.isButtonCampaignDisabled = !this.isButtonCampaignDisabled;
        this.addCampaignAction.emit();
      }
    }
  };


  getCurrent() {
    this.userService.getCurrent().subscribe(profil => { this.profil = profil });
  };

  addPet() {
    this.isButtonPetDisabled = !this.isButtonPetDisabled;
    this.addAction = 'ADD'
    if (this.isButtonPetDisabled) {
      this.addPetAction.emit(this.addAction);
    } else {
      this.addPetAction.emit();
    }
  };

  addCampaign() {
    this.isButtonCampaignDisabled = !this.isButtonCampaignDisabled;
    this.addAction = 'ADD';
    if (this.isButtonCampaignDisabled) {
      this.addCampaignAction.emit(this.addAction);
    } else {
      this.addCampaignAction.emit();
    }
  };

  viewPetById(id: string) {
    const userForPetAction = new UserForPetAction();
    this.addAction = 'VIEW'
    userForPetAction.action = this.addAction;
    userForPetAction.id = id;
    this.viewPetByIdAction.emit(userForPetAction);
  };

}
