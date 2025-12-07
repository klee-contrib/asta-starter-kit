import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'profils',
    loadChildren: () => import('./views/profils/profils.routes').then((m) => m.routes),
  },
];
