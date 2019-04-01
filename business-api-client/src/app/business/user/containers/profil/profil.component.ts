import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { User, UserAction } from '../../models/profil.model';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent {

  @Input()
  profil: User;

  @Output() userAction: EventEmitter<UserAction> = new EventEmitter();

  panelOpenState = false;

  private action: string;

  constructor(
    private router: Router,
    private route: ActivatedRoute,
  ) { }

  addPet() {
    this.userAction.emit({ action: 'ADD_PET', id: '' });
  };

  viewPetById(id: string) {
    this.userAction.emit({ action: 'VIEW_PET', id: id });
  };

  updatePetById(id: string) {
    this.userAction.emit({ action: 'UPDATE_PET', id: id });
  };

  addCampaign() {
    this.userAction.emit({ action: 'ADD_CAMPAIGN', id: '' });
  };

  viewCampaignById(id: string) {
    this.userAction.emit({ action: 'VIEW_CAMPAIGN', id: id });
  };

  updateCampaignById(id: string) {
    this.userAction.emit({ action: 'UPDATE_CAMPAIGN', id: id });
  };


  onDeleteSucceeds(idDelete: string) {
    if (idDelete) {
      let lengthList = this.profil.pets.length;
      for (let index = 0; index < lengthList; index++) {
        if (this.profil.pets[index].functionalIdentifier === idDelete) {
          this.profil.pets.splice(index, 1);
          break;
        }
      };
      lengthList = this.profil.adverts.length;
      for (let index = 0; index < lengthList; index++) {
        if (this.profil.adverts[index].functionalIdentifier === idDelete) {
          this.profil.adverts.splice(index, 1);
          break;
        }
      };
    }
  }
}
