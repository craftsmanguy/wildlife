import { Component, OnInit } from '@angular/core';

import { OptionSearch } from '../../commons/model';

import { CampaignService } from '../../services/campaign.service';

import { Campaign } from '../../campaign/model';
import { Topic, Parameter } from '../../commons/model';

import { map } from 'rxjs/operators';


@Component({
  selector: 'app-visibility',
  templateUrl: './visibility.component.html',
  styleUrls: ['./visibility.component.css']
})
export class VisibilityComponent implements OnInit {

  campaigns: Campaign[];
  parametersSearch: OptionSearch;
  topics: Topic[];

  constructor(
    private campaignService: CampaignService,
  ) { }

  ngOnInit() {
    this.getElementsOfFilter();

  };

  onParametersSearch(search: OptionSearch) {
    this.parametersSearch = search;
    this.getCampaigns();
  };

  getCampaigns() {
    this.campaignService.search().subscribe(data => { this.campaigns = data });
    this.getElementsOfFilter();
  };

  getElementsOfFilter() {
    const fieldToAccepted = ['formats', 'name', 'feature'];

    const topics = new Array<Topic>();

    if (this.campaigns !== undefined) {

      this.campaigns.forEach(function (campaign) {
        for (const field of Object.keys(campaign)) {

          if (typeof campaign[field] === 'object') {
            campaign[field].forEach(function (subObject) {
              for (const subfield of Object.keys(subObject)) {

                const topicFiltered = topics.filter(topic => topic.name.includes(field + '_' + subfield));
                const indexTopic = topics.indexOf(topicFiltered[0]);

                if (fieldToAccepted.indexOf(field) !== -1 && fieldToAccepted.indexOf(subfield) !== -1) {

                  if (topicFiltered.length === 0) {
                    const topicTmp = new Topic();
                    topicTmp.name = field + '_' + subfield;
                    topicTmp.values = new Array<Parameter>();
                    topicTmp.values.push({ code: subObject[subfield], libelle: subObject[subfield], value: false });
                    topics.push(topicTmp);
                  } else {

                    const paramFiltered = topicFiltered[0].values.filter(param => param.code.includes(subObject[subfield]));
                    if (subObject[subfield] !== undefined && paramFiltered.length === 0) {
                      topicFiltered[0].values.push({ code: subObject[subfield], libelle: subObject[subfield], value: false });
                      topics[indexTopic] = topicFiltered[0];
                    }
                  }
                }
              }
            })

          } else if (typeof campaign[field] === 'number') {

          } else if (typeof campaign[field] === 'string' && fieldToAccepted.indexOf(field) !== -1) {
            const topicFiltered = topics.filter(topic => topic.name.includes(field));

            if (topicFiltered.length === 0) {
              const topicTmp = new Topic();
              topicTmp.name = field;
              topicTmp.values = new Array<Parameter>();
              topicTmp.values.push({ code: campaign[field], libelle: campaign[field], value: false });
              topics.push(topicTmp);
            } else {
              const indexTopic = topics.indexOf(topicFiltered[0]);
              const paramFiltered = topicFiltered[0].values.filter(value => value.code.includes(campaign[field]));
              if (campaign[field] !== undefined && paramFiltered.length === 0) {
                topicFiltered[0].values.push({ code: campaign[field], libelle: campaign[field], value: false });
                topics[indexTopic] = topicFiltered[0];
              }
            }
          }

        }
      });
    }
    this.topics = topics;
  };

  setFieldInTopic(topics: Topic[], field: string) {
    if (topics.filter(topic => topic.name.includes(field)).length === 0) {
      const topicTmp = new Topic();
      topicTmp.name = field;
      topics.push(topicTmp);
    }
  };



}
