import { Component, input } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { EntityToForm } from 'ngx-focus-entities';
import {
  ProfilWriteEntity,
  ProfilWriteEntityType,
} from '../../../../model/securite/profil/profil-write';

@Component({
  selector: 'app-profil-informations-form',
  imports: [FormsModule, MatFormFieldModule, MatInputModule, ReactiveFormsModule],
  templateUrl: './profil-informations-form.html',
  styleUrl: './profil-informations-form.css',
})
export class ProfilInformationsForm {
  profilForm = input.required<EntityToForm<ProfilWriteEntityType>>();
  ProfilWriteEntity = ProfilWriteEntity;
}
