export class AbstractPet {
    functionalIdentifier: string;
    name: string;
};

export class Pet extends AbstractPet {
    birth: number;
    description: string;
    gender: string;
    lof: boolean;
    userForPet: string;
    race: Race;
};

export class Gender {
    code: string;
    label: string;
};

export const GENDERS: Gender[] = [
    { code: 'MALE', label: 'Male' },
    { code: 'FEMALE', label: 'Female' },
    { code: 'OTHER', label: 'Other' }
];

export class Race {
    constructor(public code: string, public name: string) { }
}

