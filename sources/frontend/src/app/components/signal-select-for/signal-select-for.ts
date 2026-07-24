import { NgComponentOutlet } from '@angular/common';
import { Component, input, resource } from '@angular/core';
import { FieldTree } from '@angular/forms/signals';
import { FieldEntry, ZodTypeSingle } from '@focus4/entities';
import { output } from 'zod/v4/mini';
import { InputSignalsOf } from '../abstract-input';
import { SignalDisplayFor } from '../signal-display-for/signal-display-for';
import { SignalInputSelect } from '../signal-input-select/signal-input-select.component';

@Component({
  selector: 'app-signal-select-for',
  imports: [NgComponentOutlet, SignalDisplayFor],
  templateUrl: './signal-select-for.html',
})
export class SignalSelectFor<
  InputProps = {},
  IC extends InputSignalsOf<InputProps> = InputSignalsOf<InputProps>,
  D extends Domain<ZodTypeSingle, IC> = Domain<ZodTypeSingle>,
  T extends output<D['schema']> = output<D['schema']>,
  O = any,
> {
  readonly inputProps = input<InputProps>();
  readonly formField =
    input.required<
      FieldTree<string | NonNullable<boolean> | NonNullable<number> | null, string, 'writable'>
    >();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
  readonly isEdit = input.required<boolean>();
  readonly data = input<O[]>([]); // List, reference list
  readonly ref = input.required<{
    type?: O;
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
          : Promise.resolve(SignalInputSelect as any))
      );
    },
  });
}
