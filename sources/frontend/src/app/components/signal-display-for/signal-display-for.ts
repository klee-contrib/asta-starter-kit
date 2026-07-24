import { NgComponentOutlet } from '@angular/common';
import { Component, computed, input, resource } from '@angular/core';
import { FieldTree } from '@angular/forms/signals';
import { FieldEntry, ZodTypeSingle } from '@focus4/entities';
import { output } from 'zod';
import { DisplayField } from '../display-field/display-field';

@Component({
  selector: 'app-signal-display-for',
  imports: [NgComponentOutlet],
  templateUrl: './signal-display-for.html',
})
export class SignalDisplayFor<
  D extends Domain<ZodTypeSingle> = Domain<ZodTypeSingle>,
  T extends output<D['schema']> = output<D['schema']>,
  O = any,
> {
  readonly formField =
    input.required<FieldTree<string | number | NonNullable<boolean> | null, string, 'writable'>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
  protected readonly label = computed(() => this.fieldEntry().label);
  protected readonly value = computed(() => {
    const ref = this.ref();
    const data = this.data();
    const value = this.formField()().value();
    if (ref) {
      return data.find((o) => o[ref.valueKey] === value)?.[ref.labelKey];
    }
    return value;
  });
  readonly data = input<O[]>([]); // List, reference list
  readonly ref = input<{
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
        p.params.domain.loadDisplayComponent?.() ??
        (p.params.domain.displayComponent
          ? Promise.resolve(p.params.domain.displayComponent)
          : Promise.resolve(DisplayField))
      );
    },
  });
}
