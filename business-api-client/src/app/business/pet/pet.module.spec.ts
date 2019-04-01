import { PetModule } from './pet.module';

describe('PetModule', () => {
  let petModule: PetModule;

  beforeEach(() => {
    petModule = new PetModule();
  });

  it('should create an instance', () => {
    expect(petModule).toBeTruthy();
  });
});
