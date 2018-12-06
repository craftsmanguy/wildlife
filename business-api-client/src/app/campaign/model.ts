export class OptionCampain {
    code: string;
    label: string;
};

export const OPTIONSCAMPAIGN: OptionCampain[] = [
    { code: 'REQUEST', label: 'Request' },
    { code: 'OFFER', label: 'Offer' }
];



export class AbstractCampaign {
    functionalIdentifier: string;
    title: string;
    constructor() {
    };
};

export class Campaign extends AbstractCampaign {
    startDate: Date;
    endDate: Date;
    description: string;
    formats: Format[];
};


export class Format {
    code: string;
    feature: string;
    name: string;
};

