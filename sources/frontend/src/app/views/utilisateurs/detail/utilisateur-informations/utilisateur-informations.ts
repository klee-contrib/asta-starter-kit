import { DatePipe } from '@angular/common';
import { Component, effect, inject, input, output, signal } from '@angular/core';
import { form } from '@angular/forms/signals';
import { MatButton } from '@angular/material/button';
import { MatDivider } from '@angular/material/divider';
import { MatIcon } from '@angular/material/icon';
import { buildModel, buildSchema } from 'ngx-focus-entities';
import {
  UtilisateurRead,
  UtilisateurReadEntity,
} from '../../../../../model/securite/utilisateur/utilisateur-read';
import { UtilisateurWriteEntity } from '../../../../../model/securite/utilisateur/utilisateur-write';
import { UtilisateurService } from '../../../../../services/securite/utilisateur/utilisateur.service';
import { DisplayField } from '../../../../components/display-field/display-field';
import { ReferenceLoaderService } from '../../../../services/reference/references.service';
import { UtilisateurInformationsForm } from '../../utilisateur-informations-form/utilisateur-informations-form';

@Component({
  selector: 'app-utilisateur-informations',
  imports: [MatIcon, MatDivider, DisplayField, MatButton, UtilisateurInformationsForm],
  templateUrl: './utilisateur-informations.html',
  styleUrl: './utilisateur-informations.css',
})
export class UtilisateurInformations {
  utilisateur = input.required<UtilisateurRead>();
  utilisateurStore = signal(buildModel(UtilisateurWriteEntity));
  referenceService = inject(ReferenceLoaderService);

  private readonly utilisateurService = inject(UtilisateurService);
  protected readonly UtilisateurReadEntity = UtilisateurReadEntity;
  protected readonly UtilisateurWriteEntity = UtilisateurWriteEntity;
  constructor() {
    effect(() => {
      const ut = this.utilisateur();
      this.utilisateurStore.set(buildModel(UtilisateurWriteEntity, ut));
    });
  }
  isEdit = signal<boolean>(false);

  utilisateurSignalForm = form(this.utilisateurStore, buildSchema(UtilisateurWriteEntity));

  edit() {
    this.isEdit.set(true);
  }
  saved = output<UtilisateurRead>();
  save() {
    const usf = this.utilisateurSignalForm();
    if (usf.valid()) {
      this.utilisateurService
        .updateUtilisateur(this.utilisateur().id!, usf.value() as any)
        .subscribe((value) => {
          this.isEdit.set(false);
          this.saved.emit(value);
        });
    } else {
      console.error("Le formulaire n'est pas valide", usf.errorSummary());
    }
  }
  cancel() {
    this.isEdit.set(false);
    this.utilisateurSignalForm().reset(this.utilisateur() as any);
  }
}
