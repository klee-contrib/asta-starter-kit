import { DatePipe } from '@angular/common';
import { Component, computed, input } from '@angular/core';
import { FieldEntry, isDateSchema, isDateTimeSchema, ZodTypeSingle } from '@focus4/entities';
import { output, ZodType } from 'zod';

@Component({
  selector: 'app-display-field',
  imports: [DatePipe],
  templateUrl: './display-field.html',
  styleUrl: './display-field.css',
})
export class DisplayField<
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
  isDate = computed(() => {
    const fieldEntry = this.fieldEntry();
    if (fieldEntry) {
      return isDateSchema(fieldEntry.domain.schema) || isDateTimeSchema(fieldEntry.domain.schema);
    }
    return false;
  });
  _value = computed(() => {
    const value = this.value();
    if (value === undefined) {
      return '-';
    }
    if (value === true || value === false) {
      return value ? 'Oui' : 'Non';
    }
    if (value) {
      return '' + value;
    }
    return '';
  });
}
