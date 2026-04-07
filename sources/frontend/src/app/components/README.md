# Architecture des composants de formulaires avec ngx-focus-entities

## Vue d'ensemble

Ce projet utilise `ngx-focus-entities` pour créer des formulaires typés et structurés automatiquement à partir de définitions d'entités. Cette approche permet de centraliser la logique de validation et de présentation dans des **domains** réutilisables.

### Composants principaux

- **`field-for`** : Composant principal qui bascule automatiquement entre mode édition et affichage
- **`input-for`** : Charge dynamiquement le bon composant d'input selon le domain
- **`display-for`** : Charge dynamiquement le bon composant d'affichage selon le domain
- **Composants d'input spécialisés** : `input-text`, `input-number`, `input-boolean`, `input-date`, etc.

## 1. Définition des domains

Les domains sont définis dans `domains.ts` et définissent :

- Le **schema Zod** pour la validation
- Le **composant d'input** associé (avec ou sans lazy loading)
- Le **composant d'affichage** associé (optionnel)

```typescript
import { domain } from 'ngx-focus-entities';
import z from 'zod';

export const DO_LIBELLE = domain({
  schema: z.string().max(100),
});

export const DO_BOOLEEN = domain({
  schema: z.boolean(),
  loadInputComponent: () =>
    import('./src/app/components/input-boolean/input-boolean').then((m) => m.InputBoolean),
});

export const DO_DATE = domain({
  schema: z.iso.date(),
  loadInputComponent: () =>
    import('./src/app/components/input-date/input-date').then((m) => m.InputDate),
});

export const DO_ENTIER = domain({
  schema: z.number(),
  loadInputComponent: () =>
    import('./src/app/components/input-number/input-number').then((m) => m.InputNumber),
});
```

### Lazy loading vs import direct

- **Avec `loadInputComponent`** : Le composant est chargé de manière asynchrone uniquement quand nécessaire (optimise le bundle)
- **Avec `inputComponent`** : Le composant est importé directement (utilisé pour les composants très fréquents)
- **Sans configuration** : Par défaut, `input-for` utilise `InputText`

## 2. Définition des entités

Les entités sont générées automatiquement avec TopModel et utilisent les domains définis :

```typescript
import { DO_BOOLEEN, DO_CODE, DO_DATE, DO_EMAIL, DO_ID, DO_LIBELLE } from "@domains";
import { e, entity, EntityToType } from "@focus4/entities";

export type UtilisateurWrite = EntityToType<UtilisateurWriteEntityType>;
export type UtilisateurWriteEntityType = typeof UtilisateurWriteEntity;

export const UtilisateurWriteEntity = entity({
  nom: e.field(DO_LIBELLE, f => f
    .label("Nom")
  ),
  prenom: e.field(DO_LIBELLE, f => f
    .label("Prénom")
  ),
  email: e.field(DO_EMAIL, f => f
    .label("Adresse email")
  ),
  dateNaissance: e.field(DO_DATE, f => f.optional()
    .label("Date de naissance")
  ),
  actif: e.field(DO_BOOLEEN, f => f.defaultValue(true)
    .label("Actif")
  ),
});
```

Chaque champ possède :

- Un **domain** qui définit le type et la validation
- Un **label** pour l'affichage
- Des modificateurs optionnels : `.optional()`, `.defaultValue()`

## 3. Initialisation des formulaires

L'utilisation de `ngx-focus-entities` simplifie l'initialisation des formulaires Angular. La fonction `buildForm` permet d'initaliser un FormGroup Angular avec les validateurs Zod définis dans les domains. Le type `EntityToForm<E>` correspond à `FormGroup` typé avec l'entité correspondante (aucune surcharge).

```typescript
import { EntityToForm } from 'ngx-focus-entities';
import { UtilisateurWriteEntity, UtilisateurWriteEntityType } from './model/utilisateur-write';

@Component({
  selector: 'app-utilisateur-form',
  imports: [FieldFor],
  templateUrl: './utilisateur-form.html',
})
export class UtilisateurForm {
  utilisateurForm = input.required<EntityToForm<UtilisateurWriteEntityType>>();
  UtilisateurWriteEntity = UtilisateurWriteEntity;
}
```

Le `FormGroup` généré contient automatiquement :

- Les contrôles pour chaque champ de l'entité
- Les validateurs Zod configurés dans les domains
- Le typage TypeScript complet

## 4. Utilisation du composant `field-for`

Le composant `field-for` est le composant principal pour afficher un champ de formulaire. Il gère automatiquement le basculement entre mode édition et affichage.

### Utilisation basique

```html
<form [formGroup]="utilisateurForm()">
  <app-field-for
    [control]="utilisateurForm().controls.nom"
    [fieldEntry]="UtilisateurWriteEntity.nom"
    [isEdit]="isEdit()"
  />
  
  <app-field-for
    [control]="utilisateurForm().controls.email"
    [fieldEntry]="UtilisateurWriteEntity.email"
    [isEdit]="isEdit()"
  />
</form>
```

### Props du composant `field-for`

- **`control`** (required) : Le `FormControl` Angular associé au champ
- **`fieldEntry`** (required) : La définition du champ depuis l'entité (contient le domain, label, etc.)
- **`isEdit`** (required) : `true` pour afficher l'input, `false` pour afficher en lecture seule
- **`inputProps`** (optional) : Propriétés personnalisées à passer au composant d'input

### Passage de propriétés personnalisées aux inputs

Certains composants d'input acceptent des propriétés supplémentaires :

```typescript
export class UtilisateurForm {
  dateNaissanceInputProps: { maxDate?: DateTime } = {
    maxDate: DateTime.now(),
  };
}
```

```html
<app-field-for
  [control]="utilisateurForm().controls.dateNaissance"
  [fieldEntry]="UtilisateurWriteEntity.dateNaissance"
  [isEdit]="isEdit()"
  [inputProps]="dateNaissanceInputProps"
/>
```

## 5. Sélection automatique des composants d'input selon le domain

### Fonctionnement de `input-for`

Le composant `input-for` charge dynamiquement le bon composant d'input en fonction du domain du champ :

1. Si le domain définit `loadInputComponent()`, il charge le composant de manière asynchrone (lazy loading)
2. Sinon, si le domain définit `inputComponent`, il l'utilise directement
3. Sinon, il utilise `InputText` par défaut

```typescript
protected readonly inputComponent = resource({
  params: () => ({
    domain: this.fieldEntry().domain,
  }),
  loader: (p) => (
    p.params.domain.loadInputComponent?.() ??
    (p.params.domain.inputComponent
      ? Promise.resolve(p.params.domain.inputComponent)
      : Promise.resolve(InputText))
  ),
});
```

Cette approche permet :

- **Code splitting** : Les composants peu utilisés ne sont chargés que si nécessaire
- **Performance** : Réduction de la taille du bundle initial
- **Flexibilité** : Possibilité de changer de composant sans modifier les formulaires

### Composants d'input disponibles

- **`input-text`** : Champ texte simple (utilisé par défaut)
- **`input-text-long`** : Zone de texte multi-lignes
- **`input-text-document`** : Texte pour documents longs
- **`input-number`** : Champ numérique avec validation de saisie
- **`input-boolean`** : Toggle switch Material
- **`input-date`** : Sélecteur de date Material avec conversion Luxon/ISO

## 6. Architecture des composants d'input

### Classe abstraite `AbstractInput`

Tous les composants d'input héritent de `AbstractInput` qui fournit :

```typescript
export abstract class AbstractInput<D extends Domain, T> {
  abstract readonly control: Signal<FormControl<T | undefined>>;
  abstract readonly fieldEntry: Signal<FieldEntry<D>>;
  protected readonly label = computed(() => this.fieldEntry().label);
  protected readonly htmlType = computed(() => this.fieldEntry().domain.htmlType ?? 'text');
}
```

### Création d'un composant d'input personnalisé

Pour créer un nouveau composant d'input :

1. Étendre `AbstractInput`
2. Définir les inputs requis `control` et `fieldEntry`
3. Implémenter le template avec Material ou d'autres composants
4. Inclure `input-errors` pour l'affichage des erreurs

```typescript
import { Component, input } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { MatFormFieldModule } from '@angular/material/form-field';
import { FieldEntry } from '@focus4/entities';
import { output, ZodString } from 'zod';
import { AbstractInput } from '../abstract-input';
import { InputErrors } from '../input-errors/input-errors';

@Component({
  selector: 'app-input-custom',
  imports: [ReactiveFormsModule, MatFormFieldModule, InputErrors],
  templateUrl: './input-custom.html',
})
export class InputCustom<
  D extends Domain<ZodString> = Domain<ZodString>,
  T extends output<D['schema']> = output<D['schema']>,
> extends AbstractInput<D, T> {
  readonly control = input.required<FormControl<T | undefined>>();
  readonly fieldEntry = input.required<FieldEntry<D, T>>();
}
```

Template (`input-custom.html`) :

```html
<mat-form-field appearance="outline">
  <mat-label>{{ label() }}</mat-label>
  <input
    matInput
    [formControl]="control()"
    [required]="fieldEntry().isRequired"
  />
  <mat-error>
    <app-input-errors [control]="control()" />
  </mat-error>
</mat-form-field>
```

## 7. Gestion des erreurs de validation

Le composant `input-errors` affiche les erreurs de validation basées sur les validateurs Zod :

```html
@if (control().hasError('required')) {
  Ce champ est obligatoire
} @else if (control().hasError('formatError')) {
  {{ control().getError('formatError')?.issues[0].message }}
}
```

Les erreurs sont automatiquement générées par les validateurs Zod définis dans les domains.

## 8. Mode affichage avec `display-for`

Le composant `display-for` fonctionne de manière similaire à `input-for` mais pour l'affichage en lecture seule :

- Charge dynamiquement le composant d'affichage depuis `domain.loadDisplayComponent()` ou `domain.displayComponent`
- Utilise `DisplayField` par défaut qui affiche la valeur avec formatage basique (booléens → "Oui"/"Non", undefined → "-")

## 9. Composant `select-for` pour les listes déroulantes

Variante de `field-for` pour les champs de sélection avec des listes de référence ou d'entités.

**Props supplémentaires :**
- `data` : Liste des options
- `ref` : Configuration `{ type, valueKey, labelKey }` pour mapper valeur/libellé

### Avec des listes de référence (générées automatiquement)

```typescript
// Référence générée (model/references.ts)
export const typeUtilisateur = {
  type: {} as TypeUtilisateur,
  valueKey: "code",
  labelKey: "libelle"
} as const;

// Configuration dans le composant
typeUtilisateurOptions = computed(() => ({
  ref: typeUtilisateur,
  data: this.referenceService.get('typeUtilisateur').value(),
}));
```

```html
<app-select-for
  [control]="form().controls.typeUtilisateurCode"
  [fieldEntry]="Entity.typeUtilisateurCode"
  [isEdit]="isEdit()"
  [data]="typeUtilisateurOptions().data"
  [ref]="typeUtilisateurOptions().ref"
/>
```

### Avec des listes d'entités (chargées dynamiquement)

```typescript
profils = resource({
  loader: () => lastValueFrom(this.profilService.getProfils()),
});

profilsOptions = computed(() => ({
  ref: { type: {} as ProfilItem, valueKey: 'id', labelKey: 'libelle' } as const,
  data: this.profils.value() ?? [],
}));
```

## 10. Types utilitaires

### `InputSignalsOf<T>` et `InputPropsOf<T>`

Ces types permettent de définir des propriétés personnalisées pour les composants d'input de manière typée :

```typescript
export type InputPropsOf<T> = {
  [P in keyof T]-?: T[P] extends InputSignal<infer U> ? U : never;
};

export type InputSignalsOf<T> = T extends object
  ? { [K in keyof T]: InputSignal<T[K]> }
  : any;
```

Utilisés dans la définition des domains avec propriétés personnalisées :

```typescript
const DO_DATE = domain<ZodISODate, InputSignalsOf<InputDateProps>>({
  schema: z.iso.date(),
  loadInputComponent: () => import('./input-date').then(m => m.InputDate),
});
```

## Résumé de l'architecture

```
field-for (bascule édition/affichage)
  ├─ input-for (charge le bon input selon domain)
  │   └─ input-text / input-number / input-boolean / input-date / ...
  │       └─ input-errors (affiche les erreurs Zod)
  └─ display-for (charge le bon display selon domain)
      └─ display-field / display-text / ...

select-for (bascule édition/affichage + données)
  ├─ input-select (ou composant custom)
  │   └─ mat-select + input-errors
  └─ display-for (affiche le libellé)
```

Cette architecture permet :

- **Réutilisabilité** : Les domains et composants sont réutilisables dans toute l'application
- **Type-safety** : TypeScript garantit la cohérence entre entités, forms et composants
- **Maintenabilité** : La logique de validation et présentation est centralisée
- **Performance** : Lazy loading des composants peu utilisés
- **Cohérence** : Tous les formulaires suivent les mêmes conventions
