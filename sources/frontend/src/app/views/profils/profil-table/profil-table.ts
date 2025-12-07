import { Component, inject, resource } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { lastValueFrom } from 'rxjs';
import { ProfilService } from '../../../../services/securite/profil';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-profil-table',
  imports: [MatTableModule, RouterLink],
  templateUrl: './profil-table.html',
  styleUrl: './profil-table.css',
})
export class ProfilTable {
  protected profils = resource({
    loader: () => {
      return lastValueFrom(this.profilService.getProfils());
    },
    defaultValue: [],
  });
  protected profilService = inject(ProfilService);
  displayedColumns = ['libelle', 'nombreUtilisateurs'];
}
