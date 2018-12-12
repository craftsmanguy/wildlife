
export class User {
    pseudonym: string;
    postalCode: string;
    city: string;
    country: string;
    pets: PetMinimal[];
    adverts: CampaignMinimal[];
};

export class PetMinimal {
    functionalIdentifier: string;
    name: string;
};

export class CampaignMinimal {
    functionalIdentifier: string;
    title: string;
};

export class UserAction {
    action: string;
    id: string;
}



