import { ChangeDetectionStrategy, Component, computed, input } from '@angular/core';
import { FieldTree, FormField } from '@angular/forms/signals';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatError, MatFormFieldModule } from '@angular/material/form-field';
import { MatInput, MatInputModule } from '@angular/material/input';
import { FieldEntry } from '@focus4/entities';
import { DateTime } from 'luxon';
import { output, ZodISODate } from 'zod';
import { SignalAbstractInput } from '../signal-abstract-input';
import { SignalInputErrors } from '../signal-input-errors/signal-input-errors';

export type SignalInputDateProps = {
  maxDate?: DateTime;
};

@Component({
  selector: 'app-signal-input-date',
  imports: [
    MatInput,
    MatFormFieldModule,
    MatInputModule,
    MatError,
    FormField,
    SignalInputErrors,
    MatDatepickerModule,
  ],
  templateUrl: './signal-input-date.html',
})
export class SignalInputDate<
  D extends Domain<ZodISODate> = Domain<ZodISODate>,
  T extends output<D['schema']> = output<D['schema']>,
> extends SignalAbstractInput<D> {
  readonly formField = input.required<FieldTree<string, string, 'writable'>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();

  readonly maxDate = input<SignalInputDateProps['maxDate']>();

  // L'input date natif attend une date ISO (`YYYY-MM-DD`), tout comme le champ signal.
  protected readonly max = computed(() => this.maxDate()?.toISODate() ?? null);
}
