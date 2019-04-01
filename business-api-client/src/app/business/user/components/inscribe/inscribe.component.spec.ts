import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { InscribeComponent } from './inscribe.component';

describe('InscribeComponent', () => {
  let component: InscribeComponent;
  let fixture: ComponentFixture<InscribeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ InscribeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(InscribeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
