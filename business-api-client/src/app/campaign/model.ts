export class Campaign {
    functionalIdentifier: string;
    startDate: Date;
    endDate: Date;
    title: string;
    description: string;
    formats: Format[];
    constructor() {
    };
};

export class OptionCampain {
    code: string;
    label: string;
};

export const OPTIONSCAMPAIGN: OptionCampain[] = [
    { code: 'REQUEST', label: 'Request' },
    { code: 'OFFER', label: 'Offer' }
];

export class Format {
    code: string;
    feature: string;
    name: string;
};

