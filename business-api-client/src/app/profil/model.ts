
import { AbstractCampaign } from '../campaign/model';

export class User {
    pseudonym: string;
    postalCode: string;
    city: string;
    country: string;
    pets: PetMinimal[];
    adverts: AbstractCampaign[];
};

export class PetMinimal {
    functionalIdentifier: string;
    name: string;
};

export class UserForPetAction {
    action: string;
    id: string;
}



