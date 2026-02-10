import { Component, inject, input, resource } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { UtilisateurService } from '../../../../../services/securite/utilisateur/utilisateur.service';
import { UtilisateurInformations } from '../utilisateur-informations/utilisateur-informations';
import { UtilisateurRead } from '../../../../../model/securite/utilisateur/utilisateur-read';

@Component({
  selector: 'app-utilisateur-detail',
  imports: [UtilisateurInformations],
  templateUrl: './utilisateur-detail.html',
  styleUrl: './utilisateur-detail.css',
})
export class UtilisateurDetail {
  protected utilisateurService = inject(UtilisateurService);
  readonly id = input.required<number>();
  protected utilisateur = resource({
    params: () => {
      return { id: this.id() };
    },
    loader: ({ params }) => {
      return lastValueFrom(this.utilisateurService.getUtilisateur(params.id));
    },
  });
  saved(utilisateurRead: UtilisateurRead) {
    this.utilisateur.set(utilisateurRead);
  }
}
