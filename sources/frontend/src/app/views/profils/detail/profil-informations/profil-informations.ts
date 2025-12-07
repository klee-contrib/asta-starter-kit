import { DatePipe } from '@angular/common';
import { Component, input } from '@angular/core';
import { ProfilRead, ProfilReadEntity } from '../../../../../model/securite/profil/profil-read';
import { MatIcon } from '@angular/material/icon';
import { MatDivider } from '@angular/material/divider';
import { DisplayField } from '../../../../components/display-field/display-field';

@Component({
  selector: 'app-profil-informations',
  imports: [DatePipe, MatIcon, MatDivider, DisplayField],
  templateUrl: './profil-informations.html',
  styleUrl: './profil-informations.css',
})
export class ProfilInformations {
  ProfilReadEntity = ProfilReadEntity;
  profil = input.required<ProfilRead>();
}
