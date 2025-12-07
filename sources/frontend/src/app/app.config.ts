import { ApplicationConfig, provideBrowserGlobalErrorListeners, LOCALE_ID } from '@angular/core';
import { provideRouter, withComponentInputBinding } from '@angular/router';

import { provideHttpClient, withInterceptorsFromDi } from '@angular/common/http';
import { provideOAuthClient } from 'angular-oauth2-oidc';
import { routes } from './app.routes';
import {
  provideLuxonDateAdapter,
  MAT_LUXON_DATE_ADAPTER_OPTIONS,
} from '@angular/material-luxon-adapter';
export const appConfig: ApplicationConfig = {
  providers: [
    provideBrowserGlobalErrorListeners(),
    provideRouter(routes, withComponentInputBinding()),
    provideOAuthClient({
      resourceServer: {
        sendAccessToken: true,
        allowedUrls: ['/'],
      },
    }),
    provideHttpClient(withInterceptorsFromDi()),
    { provide: LOCALE_ID, useValue: 'fr-FR' },
    {
      provide: MAT_LUXON_DATE_ADAPTER_OPTIONS,
      useValue: {
        useUtc: true,
        firstDayOfWeek: 0,
        defaultOutputCalendar: 'gregory',
      },
    },
    provideLuxonDateAdapter(),
  ],
};
