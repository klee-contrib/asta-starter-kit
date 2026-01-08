import { Component, computed, input, resource } from '@angular/core';
import { FormControl } from '@angular/forms';
import { FieldEntry, ZodTypeSingle } from '@focus4/entities';
import { output } from 'zod';
import { DisplayField } from '../display-field/display-field';
import { NgComponentOutlet } from '@angular/common';

@Component({
  selector: 'app-display-for',
  imports: [NgComponentOutlet],
  templateUrl: './display-for.html',
})
export class DisplayFor<
  D extends Domain<ZodTypeSingle> = Domain<ZodTypeSingle>,
  T extends output<D['schema']> = output<D['schema']>
> {
  readonly control = input.required<FormControl<T | undefined>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
  protected readonly label = computed(() => this.fieldEntry().label);
  protected readonly value = computed(() => this.control().value);
  protected readonly inputComponent = resource({
    params: () => {
      return {
        domain: this.fieldEntry().domain,
      };
    },
    loader: (p) => {
      return (
        p.params.domain.loadDisplayComponent?.() ??
        (p.params.domain.displayComponent
          ? Promise.resolve(p.params.domain.displayComponent)
          : Promise.resolve(DisplayField))
      );
    },
  });
}
