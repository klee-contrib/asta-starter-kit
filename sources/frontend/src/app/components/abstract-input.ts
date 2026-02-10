import { computed, InputSignal, Signal } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FieldEntry } from '@focus4/entities';
import { output } from 'zod';

export abstract class AbstractInput<
  D extends Domain = any,
  T extends output<D['schema']> = output<D['schema']>,
> {
  abstract readonly control: Signal<FormControl<T | undefined>>;
  abstract readonly fieldEntry: Signal<FieldEntry<D>>;
  protected readonly label = computed(() => this.fieldEntry().label);
  protected readonly htmlType = computed(() => this.fieldEntry().domain.htmlType ?? 'text');
}
export type InputPropsOf<T> = {
  [P in keyof T]-?: T[P] extends InputSignal<infer U> ? U : never;
};

export type InputSignalsOf<T> = {
  [K in keyof T]?: InputSignal<T[K]>;
};
