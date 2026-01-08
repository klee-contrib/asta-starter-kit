import { Component, computed, input } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FieldEntry, ZodTypeSingle } from '@focus4/entities';
import { output } from 'zod/v4/mini';
import { DisplayFor } from '../display-for/display-for';
import { InputFor } from '../input-for/input-for';

@Component({
  selector: 'app-field-for',
  imports: [InputFor, DisplayFor],
  templateUrl: './field-for.html',
})
export class FieldFor<
  D extends Domain<ZodTypeSingle> = Domain<ZodTypeSingle>,
  T extends output<D['schema']> = output<D['schema']>
> {
  readonly control = input.required<FormControl<T | undefined>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
  readonly isEdit = input.required<boolean>();
}
