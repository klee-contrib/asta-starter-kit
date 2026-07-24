import { Component, input } from '@angular/core';
import { FieldTree, FormField } from '@angular/forms/signals';
import { FieldEntry, ZodTypeSingle } from '@focus4/entities';
import { output } from 'zod/v4/mini';
import { InputSignalsOf } from '../abstract-input';
import { SignalDisplayFor } from '../signal-display-for/signal-display-for';
import { SignalInputFor } from '../signal-input-for/signal-input-for';

@Component({
  selector: 'app-signal-field-for',
  imports: [SignalInputFor, SignalDisplayFor, FormField],
  templateUrl: './signal-field-for.html',
})
export class SignalFieldFor<
  InputProps = {},
  IC extends InputSignalsOf<InputProps> = InputSignalsOf<InputProps>,
  D extends Domain<ZodTypeSingle, IC> = Domain<ZodTypeSingle>,
  T extends output<D['schema']> = output<D['schema']>,
> {
  readonly inputProps = input<InputProps>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
  readonly isEdit = input.required<boolean>();
  readonly formField =
    input.required<FieldTree<string | NonNullable<boolean> | null, string, 'writable'>>();
}
