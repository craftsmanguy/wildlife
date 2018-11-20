import { WildlivesClientPage } from './app.po';

describe('wildlives-client App', () => {
  let page: WildlivesClientPage;

  beforeEach(() => {
    page = new WildlivesClientPage();
  });

  it('should display welcome message', done => {
    page.navigateTo();
    page.getParagraphText()
      .then(msg => expect(msg).toEqual('Welcome to app!!'))
      .then(done, done.fail);
  });
});
