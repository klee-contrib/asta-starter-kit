import { Component, input, signal } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInput, MatInputModule } from '@angular/material/input';
import { FieldEntry } from '@focus4/entities';
import { output, ZodNumber } from 'zod';
import { AbstractInput } from '../abstract-input';
import { MatErrorOverride } from '../input-errors/mat-error-override';

@Component({
  selector: 'app-input-number',
  imports: [ReactiveFormsModule, MatInput, MatFormFieldModule, MatInputModule, MatErrorOverride],
  templateUrl: './input-number.html',
  styleUrl: './input-number.css',
})
export class InputNumber<
  D extends Domain<ZodNumber> = Domain<ZodNumber>,
  T extends output<D['schema']> = output<D['schema']>,
> extends AbstractInput<D, T> {
  readonly control = input.required<FormControl<T | undefined>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
  _internalValue = signal(undefined as T | undefined);

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
