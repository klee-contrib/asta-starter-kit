import { Component, input } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FieldEntry, ZodTypeSingle } from '@focus4/entities';
import { output } from 'zod/v4/mini';
import { InputSignalsOf } from '../abstract-input';
import { DisplayFor } from '../display-for/display-for';
import { InputFor } from '../input-for/input-for';

@Component({
  selector: 'app-field-for',
  imports: [InputFor, DisplayFor],
  templateUrl: './field-for.html',
})
export class FieldFor<
  InputProps,
  IC extends InputSignalsOf<InputProps>,
  D extends Domain<ZodTypeSingle, IC> = Domain<ZodTypeSingle>,
  T extends output<D['schema']> = output<D['schema']>,
> {
  readonly inputProps = input<InputProps>();
  readonly control = input.required<FormControl<T | undefined>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
  readonly isEdit = input.required<boolean>();
}
