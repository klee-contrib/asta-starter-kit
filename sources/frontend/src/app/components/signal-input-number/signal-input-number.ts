import { Component, input } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { FieldTree, FormField } from '@angular/forms/signals';
import { MatError, MatFormFieldModule } from '@angular/material/form-field';
import { MatInput, MatInputModule } from '@angular/material/input';
import { FieldEntry } from '@focus4/entities';
import { output, ZodNumber } from 'zod';
import { SignalAbstractInput } from '../signal-abstract-input';
import { SignalInputErrors } from '../signal-input-errors/signal-input-errors';

@Component({
  selector: 'app-signal-input-number',
  imports: [
    ReactiveFormsModule,
    MatInput,
    MatFormFieldModule,
    MatInputModule,
    MatError,
    FormField,
    SignalInputErrors,
  ],
  templateUrl: './signal-input-number.html',
})
export class SignalInputNumber<
  D extends Domain<ZodNumber> = Domain<ZodNumber>,
  T extends output<D['schema']> = output<D['schema']>,
> extends SignalAbstractInput<D> {
  readonly formField = input.required<FieldTree<string, string, 'writable'>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();

  keypress(event: KeyboardEvent) {
    if (!['0', '1', '2', '3', '4', '5', '6', '7', '8', '9'].includes(event.key)) {
      event.preventDefault();
    }
  }
  paste(event: ClipboardEvent) {
    const data = event.clipboardData?.getData('Text');
    if (!Number.isInteger(data)) {
      event.preventDefault();
    }
  }
}
