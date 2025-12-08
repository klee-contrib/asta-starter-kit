import { ResourceRef } from '@angular/core';

/** Définition d'un type de référence. */
export interface ReferenceDefinition<T = any, VK extends keyof T = any, LK extends keyof T = any> {
  /** Propriété représentant le libellé. */
  labelKey: LK;
  /** Le type de la liste. */
  type: T;
  /** Propriété représentant la valeur. */
  valueKey: VK;
}

/** Store de référence. */
export type ReferenceStore<T> = {
  resource: ResourceRef<T[]>;
  referenceDefinition: ReferenceDefinition<T>;
};
