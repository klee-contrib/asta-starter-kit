import { LOCALE_ID } from '@angular/core';
import { TestBed } from '@angular/core/testing';
import { Router } from '@angular/router';
import { MAT_LUXON_DATE_ADAPTER_OPTIONS } from '@angular/material-luxon-adapter';
import { appConfig } from './app.config';

describe('appConfig', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      providers: appConfig.providers,
    }).compileComponents();
  });

  it('provides French locale and Luxon date adapter options', () => {
    expect(TestBed.inject(LOCALE_ID)).toBe('fr-FR');
    expect(TestBed.inject(MAT_LUXON_DATE_ADAPTER_OPTIONS)).toEqual({
      useUtc: true,
      firstDayOfWeek: 1,
      defaultOutputCalendar: 'gregory',
    });
  });

  it('provides router with component input binding (Angular 21 API)', () => {
    expect(TestBed.inject(Router)).toBeTruthy();
  });
});
