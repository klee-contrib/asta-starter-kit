import { Component, input } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { FieldTree, FormField } from '@angular/forms/signals';
import { MatOption } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelect, MatSelectChange, MatSelectTrigger } from '@angular/material/select';
import { FieldEntry } from '@focus4/entities';
import { output as ZodOutput, ZodString } from 'zod';

import { SignalAbstractInput } from '../signal-abstract-input';
import { SignalInputErrors } from '../signal-input-errors/signal-input-errors';

@Component({
  selector: 'app-signal-input-select',
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatOption,
    MatSelect,
    MatSelectTrigger,
    FormField,
    SignalInputErrors,
  ],
  templateUrl: './signal-input-select.component.html',
})
export class SignalInputSelect<
  D extends Domain<ZodString> = Domain<ZodString>,
  T extends ZodOutput<D['schema']> = ZodOutput<D['schema']>,
  O = any,
> extends SignalAbstractInput<D> {
  readonly formField = input.required<FieldTree<string, string, 'writable'>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
  readonly optionSelected = input<(v: T) => void>();
  readonly data = input<O[]>([]);
  readonly ref = input.required<{
    type: O;
    valueKey: keyof O;
    labelKey: keyof O;
  }>();

  onSelection(matSelectChange: MatSelectChange) {
    this.optionSelected()?.(matSelectChange.value);
  }
  optionToLabel(value: O) {
    return value[this.ref().labelKey];
  }
  keyToOption(value: any): O | undefined {
    return this.data().find((o) => o[this.ref().valueKey] === value);
  }
  keyToLabel(value: any) {
    const option = this.keyToOption(value);
    return option ? this.optionToLabel(option) : value;
  }
  optionToKey(value: O) {
    return value[this.ref().valueKey];
  }
}
