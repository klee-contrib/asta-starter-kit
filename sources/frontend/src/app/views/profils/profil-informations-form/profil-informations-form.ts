import { Component, input } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { EntityToSignalForm } from 'ngx-focus-entities';
import { ProfilReadEntity } from '../../../../model/securite/profil/profil-read';
import {
  ProfilWriteEntity,
  ProfilWriteEntityType,
} from '../../../../model/securite/profil/profil-write';
import { SignalFieldFor } from '../../../components/signal-field-for/signal-field-for';

@Component({
  selector: 'app-profil-informations-form',
  imports: [FormsModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule, SignalFieldFor],
  templateUrl: './profil-informations-form.html',
  styleUrl: './profil-informations-form.css',
})
export class ProfilInformationsForm {
  isEdit = input.required<boolean>();

  profilSignalForm = input.required<EntityToSignalForm<ProfilWriteEntityType>>();
  ProfilWriteEntity = ProfilWriteEntity;
  ProfilReadEntity = ProfilReadEntity;
}
