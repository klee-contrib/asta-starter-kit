import { Component, inject, OnInit, resource } from '@angular/core';
import { ProfilRead } from '../../../model/securite/profil/profil-read';
import { ProfilService } from '../../../services/securite/profil';
import { lastValueFrom } from 'rxjs';
import { MatTableModule } from '@angular/material/table';

@Component({
  selector: 'app-profil-list',
  imports: [MatTableModule],
  templateUrl: './profil-list.html',
  styleUrl: './profil-list.css',
})
export class ProfilList {
  protected profils = resource({
    loader: () => {
      return lastValueFrom(this.profilService.getProfils());
    },
    defaultValue: [],
  });
  protected profilService = inject(ProfilService);
  displayedColumns = ['libelle', 'nombreUtilisateurs'];
}
