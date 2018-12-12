import { InscriptionWildlifeModule } from './inscription-wildlife.module';

describe('InscriptionWildlifeModule', () => {
  let inscriptionWildlifeModule: InscriptionWildlifeModule;

  beforeEach(() => {
    inscriptionWildlifeModule = new InscriptionWildlifeModule();
  });

  it('should create an instance', () => {
    expect(inscriptionWildlifeModule).toBeTruthy();
  });
});
