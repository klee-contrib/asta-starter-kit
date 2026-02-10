import { Component, input } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInput, MatInputModule } from '@angular/material/input';
import { FieldEntry } from '@focus4/entities';
import { output, ZodString } from 'zod';
import { AbstractInput } from '../abstract-input';
import { MatErrorOverride } from '../input-errors/mat-error-override';

@Component({
  selector: 'app-input-text',
  imports: [ReactiveFormsModule, MatInput, MatFormFieldModule, MatInputModule, MatErrorOverride],
  templateUrl: './input-text-long.html',
  styleUrl: './input-text-long.css',
})
export class InputTextLong<
  D extends Domain<ZodString> = Domain<ZodString>,
  T extends output<D['schema']> = output<D['schema']>,
> extends AbstractInput<D, T> {
  readonly control = input.required<FormControl<T | undefined>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
}
