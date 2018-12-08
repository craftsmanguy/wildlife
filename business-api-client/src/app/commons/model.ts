export class OptionCampain {
    code: string;
    label: string;
};

export const OPTIONSCAMPAIGN: OptionCampain[] = [
    { code: 'REQUEST', label: 'Request' },
    { code: 'OFFER', label: 'Offer' }
];

export class OptionSearch {
    formats: string[];
    inputFormat: string;
    startDate: Date;
    endDate: Date;
    postalCode: string;
    city: string;
};

export class Parameter {
    code: string;
    libelle: string;
    value: boolean
};

export class Topic {
    name: string;
    values: Parameter[];
};

