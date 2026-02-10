import { Component, computed, input, OnInit } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatError, MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { FieldEntry } from '@focus4/entities';
import { DateTime } from 'luxon';
import { output, ZodISODate } from 'zod';
import { AbstractInput } from '../abstract-input';
import { InputErrors } from '../input-errors/input-errors';
export type InputDateProps = {
  maxDate?: DateTime;
};

@Component({
  selector: 'app-input-date',
  imports: [
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    InputErrors,
    MatError,
  ],
  templateUrl: './input-date.html',
})
export class InputDate<
  D extends Domain<ZodISODate> = Domain<ZodISODate>,
  T extends output<D['schema']> = output<D['schema']>,
>
  extends AbstractInput<D, T>
  implements OnInit
{
  readonly control = input.required<FormControl<T | undefined>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();

  readonly maxDate = input<InputDateProps['maxDate']>();

  readonly internalControl = computed(() => {
    let value;
    const controlValue = this.control().value;
    if (controlValue) {
      value = DateTime.fromISO(controlValue);
    }
    const formControl = new FormControl<DateTime | undefined>(value);
    return formControl;
  });
  ngOnInit(): void {
    this.internalControl().valueChanges.subscribe((value) => {
      const control = this.control();
      if (value) {
        const isoValue = value.toISO();
        if (isoValue) {
          control.setValue(isoValue as any);
        } else {
          control.setValue(undefined);
        }
        control.markAllAsDirty();
        control.markAllAsTouched();
        control.markAsPristine();
        control.updateValueAndValidity();
      }
    });
  }
}
