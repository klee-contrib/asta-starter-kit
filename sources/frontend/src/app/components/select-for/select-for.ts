import { Component, input, resource } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FieldEntry, ZodTypeSingle } from '@focus4/entities';
import { output } from 'zod/v4/mini';
import { InputSignalsOf } from '../abstract-input';
import { InputSelect } from '../input-select/input-select.component';
import { NgComponentOutlet } from '@angular/common';

@Component({
  selector: 'app-select-for',
  imports: [NgComponentOutlet],
  templateUrl: './select-for.html',
  styleUrl: './select-for.css',
})
export class SelectFor<
  InputProps = {},
  IC extends InputSignalsOf<InputProps> = InputSignalsOf<InputProps>,
  D extends Domain<ZodTypeSingle, IC> = Domain<ZodTypeSingle>,
  T extends output<D['schema']> = output<D['schema']>,
  O = any,
> {
  readonly inputProps = input<InputProps>();
  readonly control = input.required<FormControl<T | undefined>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
  readonly isEdit = input.required<boolean>();
  readonly data = input<O[]>([]); // List, reference list
  readonly ref = input.required<{
    type: O;
    valueKey: keyof O;
    labelKey: keyof O;
  }>();
  protected readonly inputComponent = resource({
    params: () => {
      return {
        domain: this.fieldEntry().domain,
      };
    },
    loader: (p) => {
      return (
        p.params.domain.loadInputComponent?.() ??
        (p.params.domain.inputComponent
          ? Promise.resolve(p.params.domain.inputComponent)
          : Promise.resolve(InputSelect as any))
      );
    },
  });
}
