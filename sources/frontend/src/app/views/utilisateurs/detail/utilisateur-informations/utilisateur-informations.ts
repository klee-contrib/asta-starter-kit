import { DatePipe } from '@angular/common';
import { Component, computed, inject, input, output, signal } from '@angular/core';
import { MatButton } from '@angular/material/button';
import { MatDivider } from '@angular/material/divider';
import { MatIcon } from '@angular/material/icon';
import { buildForm } from 'ngx-focus-entities';
import {
  UtilisateurRead,
  UtilisateurReadEntity,
} from '../../../../../model/securite/utilisateur/utilisateur-read';
import { UtilisateurWriteEntity } from '../../../../../model/securite/utilisateur/utilisateur-write';
import { UtilisateurService } from '../../../../../services/securite/utilisateur/utilisateur.service';
import { DisplayField } from '../../../../components/display-field/display-field';
import { ReferenceLoaderService } from '../../../../services/reference/references.service';
import { UtilisateurInformationsForm } from '../../utilisateur-informations-form/utilisateur-informations-form';
import { ReferencePipe } from '../../../../services/reference/reference.pipe';

@Component({
  selector: 'app-utilisateur-informations',
  imports: [
    DatePipe,
    MatIcon,
    MatDivider,
    DisplayField,
    MatButton,
    UtilisateurInformationsForm,
    ReferencePipe,
  ],
  templateUrl: './utilisateur-informations.html',
  styleUrl: './utilisateur-informations.css',
})
export class UtilisateurInformations {
  utilisateur = input.required<UtilisateurRead>();

  referenceService = inject(ReferenceLoaderService);

  private readonly utilisateurService = inject(UtilisateurService);
  protected readonly UtilisateurReadEntity = UtilisateurReadEntity;
  protected readonly UtilisateurWriteEntity = UtilisateurWriteEntity;

  isEdit = signal<boolean>(false);

  utilisateurForm = computed(() => buildForm(UtilisateurWriteEntity, this.utilisateur()));

  edit() {
    this.isEdit.set(true);
  }
  saved = output<UtilisateurRead>();
  save() {
    if (this.utilisateurForm()?.valid) {
      this.utilisateurService
        .updateUtilisateur(this.utilisateur().id!, this.utilisateurForm().value)
        .subscribe((value) => {
          this.isEdit.set(false);
          this.saved.emit(value);
        });
    } else {
      console.error("Le formulaire n'est pas valide", this.utilisateurForm());
    }
  }
  cancel() {
    this.isEdit.set(false);
    this.utilisateurForm().reset(this.utilisateur());
  }
}
