import { Route } from '@angular/router';

export const routes: Route[] = [
  {
    path: '',
    loadComponent: () => import('./utilisateurs-header/utilisateurs-header').then((m) => m.UtilisateursHeader),
    outlet: 'header',
  },
  {
    path: '',
    loadComponent: () => import('./utilisateur-table/utilisateur-table').then((m) => m.UtilisateurTable),
  },
  {
    path: ':id',
    loadComponent: () => import('./detail/utilisateur-detail/utilisateur-detail').then((m) => m.UtilisateurDetail),
  },
];
