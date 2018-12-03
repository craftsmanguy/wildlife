import { AbstractPet } from '../pet/model';
import { AbstractCampaign } from '../campaign/model';

export class User {
    pseudonym: string;
    postalCode: string;
    city: string;
    country: string;
    pets: AbstractPet[];
    adverts: AbstractCampaign[];
};

export class UserForPetAction {
    action: string;
    id: string;
}



