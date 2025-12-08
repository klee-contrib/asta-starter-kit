import { Signal } from '@angular/core';
import { Entity, EntityToType } from '@focus4/entities';

export type EntityStore<T extends Entity> = {
  signal: Signal<EntityToType<T> | undefined>;
  entity: T;
};
