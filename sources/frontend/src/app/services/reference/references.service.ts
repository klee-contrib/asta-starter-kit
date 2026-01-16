import { inject, Injectable, resource } from '@angular/core';
import { lastValueFrom } from 'rxjs';
import { droit, typeDroit, typeUtilisateur } from '../../../model/securite/references';
import { ReferenceDefinition, ReferenceStore } from './types';
import { ReferenceService } from '../../../services/common/reference.service';

const regularReferences = {
  typeDroit,
  typeUtilisateur,
  droit,
};

export type ReferenceName = keyof typeof regularReferences;

@Injectable({ providedIn: 'root' })
export class ReferenceLoaderService {
  referenceService = inject(ReferenceService);
  addRegularReference<T>(referenceOptions: {
    name: ReferenceName;
    referenceDefinition: ReferenceDefinition<T>;
  }) {
    this.stores[referenceOptions.name] = {
      resource: resource({
        loader: () => lastValueFrom(this.referenceService.getReference(referenceOptions.name)),
        defaultValue: [],
      }),
      referenceDefinition: referenceOptions.referenceDefinition,
    };
  }
  stores = {} as Record<ReferenceName, ReferenceStore<any>>;
  constructor() {
    for (const name in regularReferences) {
      this.addRegularReference({
        name: name as ReferenceName,
        referenceDefinition: regularReferences[name as keyof typeof regularReferences] as any,
      });
    }
  }
  get(referenceName: keyof typeof this.stores) {
    const reference = this.stores[referenceName];
    return reference.resource;
  }
  reload(referenceName: keyof typeof this.stores) {
    const reference = this.stores[referenceName];
    reference.resource.reload();
  }

  getLabel(key: string, referenceName: ReferenceName): string {
    const reference = this.stores[referenceName];
    return reference.resource
      .value()
      .find((value) => value[reference.referenceDefinition.valueKey] === key)?.[
      reference.referenceDefinition.labelKey
    ];
  }
}
