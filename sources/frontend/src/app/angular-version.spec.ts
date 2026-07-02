import { signal, VERSION } from '@angular/core';

describe('Angular 21.2.17 migration', () => {
  it('resolves @angular/core to 21.2.17', () => {
    expect(VERSION.full).toBe('21.2.17');
  });

  it('runs signal APIs on the upgraded framework', () => {
    const title = signal('asta-starter-kit');
    expect(title()).toBe('asta-starter-kit');
    title.set('updated');
    expect(title()).toBe('updated');
  });
});
