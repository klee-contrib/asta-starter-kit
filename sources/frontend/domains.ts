import { domain } from 'ngx-focus-entities';
import z from 'zod';

export const DO_BOOLEEN = domain({
  schema: z.boolean(),
  loadInputComponent: () =>
    import('./src/app/components/input-boolean/input-boolean').then((m) => m.InputBoolean),
});
export const DO_CODE = domain({
  schema: z.string().max(3),
});
export const DO_ENTIER = domain({
  schema: z.number(),
  loadInputComponent: () =>
    import('./src/app/components/input-number/input-number').then((m) => m.InputNumber),
});
export const DO_CODE_LISTE = domain({
  schema: z.array(z.string().max(10)),
});
export const DO_DATE = domain({
  schema: z.iso.date(),
  loadInputComponent: () =>
    import('./src/app/components/input-date/input-date').then((m) => m.InputDate),
});
export const DO_DATE_HEURE = domain({
  schema: z.iso.datetime(),
});
export const DO_EMAIL = domain({
  schema: z.email(),
});
export const DO_ID = domain({
  schema: z.number().positive(),
});
export const DO_LIBELLE = domain({
  schema: z.string().max(100),
});
