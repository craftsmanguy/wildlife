import { TestBed, inject } from '@angular/core/testing';

import { AdvertService } from './advert.service';

describe('AdvertService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [AdvertService]
    });
  });

  it('should be created', inject([AdvertService], (service: AdvertService) => {
    expect(service).toBeTruthy();
  }));
});
