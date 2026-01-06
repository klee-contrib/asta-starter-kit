import { computed, Signal } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FieldEntry } from '@focus4/entities';
import { output } from 'zod';

export abstract class AbstractInput<
  D extends Domain = any,
  T extends output<D['schema']> = output<D['schema']>
> {
  abstract readonly control: Signal<FormControl<T>>;
  abstract readonly fieldEntry: Signal<FieldEntry<D>>;
  protected readonly label = computed(() => this.fieldEntry().label);
  protected readonly htmlType = computed(() => this.fieldEntry().domain.htmlType ?? 'text');
}
