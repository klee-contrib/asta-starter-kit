import { Component, input } from '@angular/core';
import { ReactiveFormsModule } from '@angular/forms';
import { FieldTree, FormField } from '@angular/forms/signals';
import { MatError, MatFormFieldModule } from '@angular/material/form-field';
import { MatInput, MatInputModule } from '@angular/material/input';
import { FieldEntry } from '@focus4/entities';
import { output, ZodString } from 'zod';
import { SignalAbstractInput } from '../signal-abstract-input';
import { SignalInputErrors } from '../signal-input-errors/signal-input-errors';

@Component({
  selector: 'app-signal-input-document',
  imports: [
    ReactiveFormsModule,
    MatInput,
    MatFormFieldModule,
    MatInputModule,
    MatError,
    FormField,
    SignalInputErrors,
  ],
  templateUrl: './signal-input-text-document.html',
  styleUrl: './signal-input-text-document.css',
})
export class SignalInputTextDocument<
  D extends Domain<ZodString> = Domain<ZodString>,
  T extends output<D['schema']> = output<D['schema']>,
> extends SignalAbstractInput<D> {
  readonly formField = input.required<FieldTree<string, string, 'writable'>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
}
