import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { QuickViewCampaignComponent } from './quick-view-campaign.component';

describe('QuickViewCampaignComponent', () => {
  let component: QuickViewCampaignComponent;
  let fixture: ComponentFixture<QuickViewCampaignComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ QuickViewCampaignComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(QuickViewCampaignComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
