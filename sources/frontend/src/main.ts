import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/app.config';
import { App } from './app/app';
import localeFr from '@angular/common/locales/fr';
import { registerLocaleData } from '@angular/common';
import z from 'zod';
registerLocaleData(localeFr);
z.config(z.locales['fr']());

bootstrapApplication(App, appConfig).catch((err) => console.error(err));
