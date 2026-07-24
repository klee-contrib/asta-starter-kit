import { DatePipe } from '@angular/common';
import { Component, computed, input } from '@angular/core';
import { FieldEntry, ZodTypeSingle } from '@focus4/entities';
import { output, ZodType } from 'zod';

@Component({
  selector: 'app-display-date',
  imports: [DatePipe],
  templateUrl: './display-date.html',
  styleUrl: './display-date.css',
})
export class DisplayDate<
  S extends ZodType = ZodTypeSingle,
  D extends Domain<S> = Domain<S>,
  T extends output<D['schema']> = output<D['schema']>,
> {
  /** Label du champ affiché */
  label = input<string>();
  _label = computed(() => this.label() ?? this.fieldEntry()?.label);

  /** Valeur du champ à afficher */
  value = input.required<T | undefined>();
  readonly fieldEntry = input<FieldEntry<D, T>>();

  _value = computed(() => {
    const value = this.value();
    if (value === undefined) {
      return '-';
    }
    return '' + value;
  });
}
