import { NgComponentOutlet } from '@angular/common';
import { ChangeDetectionStrategy, Component, computed, input, resource } from '@angular/core';
import { FieldTree } from '@angular/forms/signals';
import { FieldEntry, ZodTypeSingle } from '@focus4/entities';
import { output } from 'zod/v4/mini';
import { InputSignalsOf } from '../abstract-input';
import { SignalInputText } from '../signal-input-text/signal-input-text';

@Component({
  selector: 'app-signal-input-for',
  imports: [NgComponentOutlet],
  templateUrl: './signal-input-for.html',
})
export class SignalInputFor<
  InputProps = {},
  IC extends InputSignalsOf<InputProps> = InputSignalsOf<InputProps>,
  D extends Domain<ZodTypeSingle, IC> = Domain<ZodTypeSingle>,
  T extends output<D['schema']> = output<D['schema']>,
> {
  readonly formField =
    input.required<FieldTree<string | NonNullable<boolean> | null, string, 'writable'>>();
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
          : Promise.resolve(SignalInputText as any))
      );
    },
  });
}
