export class Pet {
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

