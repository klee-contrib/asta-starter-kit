import { Component, inject, resource } from '@angular/core';
import { MatTableModule } from '@angular/material/table';
import { RouterLink } from '@angular/router';
import { lastValueFrom } from 'rxjs';
import { UtilisateurService } from '../../../../services/securite/utilisateur/utilisateur.service';
import { ReferencePipe } from '../../../services/reference/reference.pipe';

@Component({
  selector: 'app-utilisateur-table',
  imports: [MatTableModule, RouterLink, ReferencePipe],
  templateUrl: './utilisateur-table.html',
  styleUrl: './utilisateur-table.css',
})
export class UtilisateurTable {
  protected utilisateurs = resource({
    loader: () => {
      return lastValueFrom(this.utilisateurService.searchUtilisateur());
    },
    defaultValue: [],
  });
  protected utilisateurService = inject(UtilisateurService);
  displayedColumns = ['nom', 'prenom', 'email', 'typeUtilisateurCode'];
}
