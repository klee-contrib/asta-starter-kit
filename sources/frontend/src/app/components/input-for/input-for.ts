import { NgComponentOutlet } from '@angular/common';
import { Component, computed, input, resource } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FieldEntry, ZodTypeSingle } from '@focus4/entities';
import { output } from 'zod/v4/mini';
import { InputSignalsOf } from '../abstract-input';
import { InputText } from '../input-text/input-text';

@Component({
  selector: 'app-input-for',
  imports: [NgComponentOutlet],
  templateUrl: './input-for.html',
})
export class InputFor<
  InputProps = {},
  IC extends InputSignalsOf<InputProps> = InputSignalsOf<InputProps>,
  D extends Domain<ZodTypeSingle, IC> = Domain<ZodTypeSingle>,
  T extends output<D['schema']> = output<D['schema']>,
> {
  readonly control = input.required<FormControl<T | undefined>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
  protected readonly label = computed(() => this.fieldEntry().label);
  readonly inputProps = input<InputProps>();
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
          : Promise.resolve(InputText as any))
      );
    },
  });
}
