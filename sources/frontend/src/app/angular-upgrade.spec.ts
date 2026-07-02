import { VERSION as coreVersion } from '@angular/core';
import { VERSION as cdkVersion } from '@angular/cdk';

describe('Angular 21.2.17 upgrade', () => {
  it('runs on @angular/core 21.2.17', () => {
    expect(coreVersion.full).toBe('21.2.17');
  });

  it('uses @angular/cdk 21.2.14 (latest Material 21.2.x patch on npm)', () => {
    expect(cdkVersion.full).toBe('21.2.14');
  });
});
