import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewPetComponent } from './view-pet.component';

describe('ViewPetComponent', () => {
  let component: ViewPetComponent;
  let fixture: ComponentFixture<ViewPetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewPetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewPetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
