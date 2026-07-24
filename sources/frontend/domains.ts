import { DateTime } from 'luxon';
import { domain } from 'ngx-focus-entities';
import z from 'zod';

export const DO_BOOLEEN = domain(z.boolean(), {
  loadInputComponent: () =>
    import('./src/app/components/signal-input-boolean/signal-input-boolean').then(
      (m) => m.SignalInputBoolean,
    ),
});
export const DO_CODE = domain(z.string().max(10));
export const DO_ENTIER = domain(z.number(), {
  loadInputComponent: () =>
    import('./src/app/components/signal-input-number/signal-input-number').then(
      (m) => m.SignalInputNumber,
    ),
});
export const DO_CODE_LISTE = domain(z.array(z.string().max(10)));
export const DO_DATE = domain(
  z.preprocess(
    (value) => (DateTime.isDateTime(value) && value.isValid ? (value.toISODate() ?? value) : value),
    z.iso.date(),
  ),
  {
    loadInputComponent: () =>
      import('./src/app/components/signal-input-date/signal-input-date').then(
        (m) => m.SignalInputDate,
      ),
    loadDisplayComponent: () =>
      import('./src/app/components/display-date/display-date').then((m) => m.DisplayDate),
  },
);
export const DO_DATE_HEURE = domain(z.iso.datetime());
export const DO_EMAIL = domain(z.email());
export const DO_ID = domain(z.number().positive());
export const DO_LIBELLE = domain(z.string().max(100));
