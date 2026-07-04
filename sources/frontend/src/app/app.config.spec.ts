import { TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting, HttpTestingController } from '@angular/common/http/testing';
import { VERSION } from '@angular/core';
import angularBuildPackage from '../../node_modules/@angular/build/package.json';
import angularCdkPackage from '../../node_modules/@angular/cdk/package.json';
import angularCliPackage from '../../node_modules/@angular/cli/package.json';
import angularMaterialPackage from '../../node_modules/@angular/material/package.json';

describe('Angular 21.2.17 / 21.2.18 tooling smoke tests', () => {
  it('uses the expected @angular/core version', () => {
    expect(VERSION.full).toBe('21.2.17');
  });

  it('resolves @angular/cli at 21.2.18', () => {
    expect(angularCliPackage.version).toBe('21.2.18');
  });

  it('resolves @angular/build at 21.2.18', () => {
    expect(angularBuildPackage.version).toBe('21.2.18');
  });

  it('keeps Material/CDK aligned at 21.2.14', () => {
    expect(angularCdkPackage.version).toBe('21.2.14');
    expect(angularMaterialPackage.version).toBe('21.2.14');
  });

  it('supports HttpClient with the testing module after the patch upgrade', () => {
    TestBed.configureTestingModule({
      providers: [provideHttpClient(), provideHttpClientTesting()],
    });

    const http = TestBed.inject(HttpTestingController);
    expect(http).toBeTruthy();
    http.verify();
  });
});
