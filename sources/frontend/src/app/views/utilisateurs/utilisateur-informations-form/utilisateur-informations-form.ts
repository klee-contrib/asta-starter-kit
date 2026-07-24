import {
  ChangeDetectionStrategy,
  Component,
  computed,
  inject,
  input,
  resource,
  signal,
} from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { form, FormField } from '@angular/forms/signals';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { DateTime } from 'luxon';
import { buildSignalForm, EntityToForm, EntityToSignalForm } from 'ngx-focus-entities';
import { lastValueFrom } from 'rxjs';
import { typeUtilisateur } from '../../../../model/securite/enums';
import { ProfilItem } from '../../../../model/securite/profil/profil-item';
import { UtilisateurReadEntity } from '../../../../model/securite/utilisateur/utilisateur-read';
import {
  UtilisateurWriteEntity,
  UtilisateurWriteEntityType,
} from '../../../../model/securite/utilisateur/utilisateur-write';
import { ProfilService } from '../../../../services/securite/profil/profil.service';
import { SignalFieldFor } from '../../../components/signal-field-for/signal-field-for';
import { ReferenceLoaderService } from '../../../services/reference/references.service';
import { SignalSelectFor } from '../../../components/signal-select-for/signal-select-for';

@Component({
  selector: 'app-utilisateur-informations-form',
  imports: [
    FormsModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    FormField,
    SignalFieldFor,
    SignalSelectFor,
  ],
  templateUrl: './utilisateur-informations-form.html',
  styleUrl: './utilisateur-informations-form.css',
})
export class UtilisateurInformationsForm {
  isEdit = input.required<boolean>();
  referenceService = inject(ReferenceLoaderService);
  utilisateurSignalForm = input.required<EntityToSignalForm<UtilisateurWriteEntityType>>();
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
