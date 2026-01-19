import { Component, input } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { EntityToForm } from 'ngx-focus-entities';
import { ProfilReadEntity } from '../../../../model/securite/profil/profil-read';
import {
  ProfilWriteEntity,
  ProfilWriteEntityType,
} from '../../../../model/securite/profil/profil-write';
import { FieldFor } from '../../../components/field-for/field-for';

@Component({
  selector: 'app-profil-informations-form',
  imports: [FormsModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule, FieldFor],
  templateUrl: './profil-informations-form.html',
  styleUrl: './profil-informations-form.css',
})
export class ProfilInformationsForm {
  isEdit = input.required<boolean>();

  profilForm = input.required<EntityToForm<ProfilWriteEntityType>>();
  ProfilWriteEntity = ProfilWriteEntity;
  ProfilReadEntity = ProfilReadEntity;
}
