import { Component, inject, input, resource } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { ProfilService } from '../../../../../services/securite/profil/profil.service';
import { ProfilInformations } from '../profil-informations/profil-informations';
import { ProfilUtilisateurs } from '../profil-utilisateurs/profil-utilisateurs';
import { ProfilRead } from '../../../../../model/securite/profil/profil-read';

@Component({
  selector: 'app-profil-detail',
  imports: [ProfilInformations, ProfilUtilisateurs],
  templateUrl: './profil-detail.html',
  styleUrl: './profil-detail.css',
})
export class ProfilDetail {
  protected profilService = inject(ProfilService);
  readonly id = input.required<number>();
  protected profil = resource({
    params: () => {
      return { id: this.id() };
    },
    loader: ({ params }) => {
      return lastValueFrom(this.profilService.getProfil(params.id));
    },
  });
  saved(profilRead: ProfilRead) {
    this.profil.set(profilRead);
  }
}
