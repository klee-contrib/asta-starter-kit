import { Component, input } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FieldTree, FormField } from '@angular/forms/signals';
import { MatSlideToggle } from '@angular/material/slide-toggle';
import { FieldEntry } from '@focus4/entities';
import { output, ZodBoolean } from 'zod';
import { SignalAbstractInput } from '../signal-abstract-input';

@Component({
  selector: 'app-signal-input-boolean',
  imports: [MatSlideToggle, FormsModule, ReactiveFormsModule, FormField],
  templateUrl: './signal-input-boolean.html',
})
export class SignalInputBoolean<
  D extends Domain<ZodBoolean> = Domain<ZodBoolean>,
  T extends output<D['schema']> = output<D['schema']>,
> extends SignalAbstractInput<D> {
  readonly formField = input.required<FieldTree<string, string, 'writable'>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
}
