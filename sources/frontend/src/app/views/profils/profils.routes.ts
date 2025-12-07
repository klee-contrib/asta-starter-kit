import { Route } from '@angular/router';

export const routes: Route[] = [
  {
    path: '',
    loadComponent: () => import('./profils-header/profils-header').then((m) => m.ProfilsHeader),
    outlet: 'header',
  },
  {
    path: '',
    loadComponent: () => import('./profil-table/profil-table').then((m) => m.ProfilTable),
  },
  {
    path: ':id',
    loadComponent: () => import('./detail/profil-detail/profil-detail').then((m) => m.ProfilDetail),
  },
];
