import { Component, input } from '@angular/core';
import { UtilisateurItem } from '../../../../../model/securite/utilisateur/utilisateur-item';
import { MatTableModule } from '@angular/material/table';
import { MatIconModule } from '@angular/material/icon';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-profil-utilisateurs',
  imports: [MatTableModule, MatIconModule, RouterLink],
  templateUrl: './profil-utilisateurs.html',
  styleUrl: './profil-utilisateurs.css',
})
export class ProfilUtilisateurs {
  utilisateurs = input.required<UtilisateurItem[]>();
}
