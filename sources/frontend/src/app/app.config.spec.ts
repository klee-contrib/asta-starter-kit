import { TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import { provideHttpClientTesting, HttpTestingController } from '@angular/common/http/testing';
import { VERSION } from '@angular/core';

describe('Angular 21.2.17 upgrade smoke tests', () => {
  it('uses the expected @angular/core version', () => {
    expect(VERSION.full).toBe('21.2.17');
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
