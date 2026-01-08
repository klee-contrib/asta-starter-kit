import { Component, input } from '@angular/core';
import { MatSlideToggle } from '@angular/material/slide-toggle';
import { FormControl, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FieldEntry } from '@focus4/entities';
import { output } from 'zod';
import { AbstractInput } from '../abstract-input';

@Component({
  selector: 'app-input-boolean',
  imports: [MatSlideToggle, FormsModule, ReactiveFormsModule],
  templateUrl: './input-boolean.html',
  styleUrl: './input-boolean.css',
})
export class InputBoolean<
  D extends Domain = any,
  T extends output<D['schema']> = output<D['schema']>
> extends AbstractInput<D, T> {
  readonly control = input.required<FormControl<T | undefined>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
}
