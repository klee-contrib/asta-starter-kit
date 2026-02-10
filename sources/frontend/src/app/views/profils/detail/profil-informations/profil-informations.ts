import { DatePipe } from '@angular/common';
import { Component, computed, inject, input, output, signal } from '@angular/core';
import { MatButton } from '@angular/material/button';
import { MatDivider } from '@angular/material/divider';
import { MatIcon } from '@angular/material/icon';
import { buildForm } from 'ngx-focus-entities';
import { ProfilRead, ProfilReadEntity } from '../../../../../model/securite/profil/profil-read';
import { ProfilWriteEntity } from '../../../../../model/securite/profil/profil-write';
import { ProfilService } from '../../../../../services/securite/profil/profil.service';
import { DisplayField } from '../../../../components/display-field/display-field';
import { ReferenceLoaderService } from '../../../../services/reference/references.service';
import { ProfilInformationsForm } from '../../profil-informations-form/profil-informations-form';

@Component({
  selector: 'app-profil-informations',
  imports: [DatePipe, MatIcon, MatDivider, DisplayField, MatButton, ProfilInformationsForm],
  templateUrl: './profil-informations.html',
  styleUrl: './profil-informations.css',
})
export class ProfilInformations {
  profil = input.required<ProfilRead>();

  referenceService = inject(ReferenceLoaderService);

  private readonly profilService = inject(ProfilService);
  protected readonly ProfilReadEntity = ProfilReadEntity;
  protected readonly ProfilWriteEntity = ProfilWriteEntity;

  isEdit = signal<boolean>(false);

  droits = computed(() => {
    const profil = this.profil();
    return profil.droitCodes
      ?.map((droitCode) => this.referenceService.getLabel(droitCode, 'droit'))
      .join(', ');
  });
  profilForm = computed(() => buildForm(ProfilWriteEntity, this.profil()));

  edit() {
    this.isEdit.set(true);
  }
  saved = output<ProfilRead>();
  save() {
    if (this.profilForm()?.valid) {
      this.profilService
        .updateProfil(this.profil().id!, this.profilForm().value)
        .subscribe((value) => {
          this.isEdit.set(false);
          this.saved.emit(value);
        });
    }
  }
  cancel() {
    this.isEdit.set(false);
  }
}
