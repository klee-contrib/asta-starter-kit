import { computed, InputSignal, Signal } from '@angular/core';
import { FieldTree } from '@angular/forms/signals';
import { FieldEntry } from '@focus4/entities';

export abstract class SignalAbstractInput<D extends Domain = any> {
  abstract readonly formField: Signal<FieldTree<string, string, 'writable'>>;
  abstract readonly fieldEntry: Signal<FieldEntry<D>>;
  protected readonly label = computed(() => this.fieldEntry().label);
  protected readonly htmlType = computed(() => this.fieldEntry().domain.htmlType ?? 'text');
}
export type InputPropsOf<T> = {
  [P in keyof T]-?: T[P] extends InputSignal<infer U> ? U : never;
};

export type InputSignalsOf<T> = T extends object
  ? {
      [K in keyof T]: InputSignal<T[K]>;
    }
  : any;
