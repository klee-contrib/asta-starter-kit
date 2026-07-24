import { Component, computed, effect, inject, input, output, signal } from '@angular/core';
import { form } from '@angular/forms/signals';
import { MatButton } from '@angular/material/button';
import { MatDivider } from '@angular/material/divider';
import { MatIcon } from '@angular/material/icon';
import { buildModel, buildSchema } from 'ngx-focus-entities';
import { ProfilRead, ProfilReadEntity } from '../../../../../model/securite/profil/profil-read';
import { ProfilWriteEntity } from '../../../../../model/securite/profil/profil-write';
import { ProfilService } from '../../../../../services/securite/profil/profil.service';
import { DisplayField } from '../../../../components/display-field/display-field';
import { ReferenceLoaderService } from '../../../../services/reference/references.service';
import { ProfilInformationsForm } from '../../profil-informations-form/profil-informations-form';

@Component({
  selector: 'app-profil-informations',
  imports: [MatIcon, MatDivider, DisplayField, MatButton, ProfilInformationsForm],
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

  profilStore = signal(buildModel(ProfilWriteEntity));
  profilSignalForm = form(this.profilStore, buildSchema(ProfilWriteEntity));

  constructor() {
    effect(() => {
      this.profilStore.set(buildModel(ProfilWriteEntity, this.profil()));
    });
  }

  droits = computed(() => {
    const profil = this.profil();
    return profil.droitCodes
      ?.map((droitCode) => this.referenceService.getLabel(droitCode, 'droit'))
      .join(', ');
  });

  edit() {
    this.isEdit.set(true);
  }
  saved = output<ProfilRead>();
  save() {
    const psf = this.profilSignalForm();
    if (psf.valid()) {
      this.profilService.updateProfil(this.profil().id!, psf.value as any).subscribe((value) => {
        this.isEdit.set(false);
        this.saved.emit(value);
      });
    } else {
      console.error("Le formulaire n'est pas valide", psf);
    }
  }
  cancel() {
    this.isEdit.set(false);
    this.profilSignalForm().reset(this.profil() as any);
  }
}
