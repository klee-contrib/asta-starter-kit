import { Component, input } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { MatOption } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatSelect, MatSelectChange, MatSelectTrigger } from '@angular/material/select';
import { FieldEntry } from '@focus4/entities';
import { output as ZodOutput, ZodString } from 'zod';

import { AbstractInput } from '../abstract-input';
import { InputErrors } from '../input-errors/input-errors';

@Component({
  selector: 'app-input-select',
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatOption,
    MatSelect,
    MatSelectTrigger,
    InputErrors,
  ],
  templateUrl: './input-select.component.html',
})
export class InputSelect<
  D extends Domain<ZodString> = Domain<ZodString>,
  T extends ZodOutput<D['schema']> = ZodOutput<D['schema']>,
  O = any,
> extends AbstractInput<D, T> {
  readonly control = input.required<FormControl<T | undefined>>();
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
