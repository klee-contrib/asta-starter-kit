import { Route } from '@angular/router';

export const routes: Route[] = [
  {
    path: '',
    loadComponent: () => import('./profil-list/profil-list').then((m) => m.ProfilList),
  },
];
