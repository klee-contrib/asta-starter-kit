import { Component, computed, inject, input, resource } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { DateTime } from 'luxon';
import { EntityToForm } from 'ngx-focus-entities';
import { lastValueFrom } from 'rxjs';
import { ProfilItem } from '../../../../model/securite/profil/profil-item';
import { typeUtilisateur, typeUtilisateurList } from '../../../../model/securite/enums';
import { UtilisateurReadEntity } from '../../../../model/securite/utilisateur/utilisateur-read';
import {
  UtilisateurWriteEntity,
  UtilisateurWriteEntityType,
} from '../../../../model/securite/utilisateur/utilisateur-write';
import { ProfilService } from '../../../../services/securite/profil/profil.service';
import { FieldFor } from '../../../components/field-for/field-for';
import { SelectFor } from '../../../components/select-for/select-for';
import { ReferenceLoaderService } from '../../../services/reference/references.service';

@Component({
  selector: 'app-utilisateur-informations-form',
  imports: [
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    FieldFor,
    SelectFor,
  ],
  templateUrl: './utilisateur-informations-form.html',
  styleUrl: './utilisateur-informations-form.css',
})
export class UtilisateurInformationsForm {
  isEdit = input.required<boolean>();
  referenceService = inject(ReferenceLoaderService);
  utilisateurForm = input.required<EntityToForm<UtilisateurWriteEntityType>>();
  profilService = inject(ProfilService);
  UtilisateurWriteEntity = UtilisateurWriteEntity;
  UtilisateurReadEntity = UtilisateurReadEntity;
  dateNaissanceInputProps: { maxDate?: DateTime } = {
    maxDate: DateTime.now(),
  };
  typeUtilisateurFieldOptions = computed(() => {
    return {
      ref: typeUtilisateur,
      data: typeUtilisateur.list,
    };
  });
  protected profils = resource({
    loader: () => {
      return lastValueFrom(this.profilService.getProfils());
    },
  });
  profilsFieldOptions = computed(() => {
    return {
      ref: { type: {} as ProfilItem, valueKey: 'id', labelKey: 'libelle' } as const,
      data: this.profils.value() ?? [],
    };
  });
}
