import { Component, input, Type } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { DateTime } from 'luxon';
import { EntityToForm } from 'ngx-focus-entities';
import { UtilisateurReadEntity } from '../../../../model/securite/utilisateur/utilisateur-read';
import {
  UtilisateurWriteEntity,
  UtilisateurWriteEntityType,
} from '../../../../model/securite/utilisateur/utilisateur-write';
import { FieldFor } from '../../../components/field-for/field-for';

@Component({
  selector: 'app-utilisateur-informations-form',
  imports: [FormsModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule, FieldFor],
  templateUrl: './utilisateur-informations-form.html',
  styleUrl: './utilisateur-informations-form.css',
})
export class UtilisateurInformationsForm {
  isEdit = input.required<boolean>();

  utilisateurForm = input.required<EntityToForm<UtilisateurWriteEntityType>>();
  UtilisateurWriteEntity = UtilisateurWriteEntity;
  UtilisateurReadEntity = UtilisateurReadEntity;
  dateNaissanceInputProps: { maxDate?: DateTime } = {
    maxDate: DateTime.now(),
  };
}
