import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'profils',
    loadChildren: () => import('./profil/profil.routes').then((m) => m.routes),
  },
];
