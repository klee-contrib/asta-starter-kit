import { Component, computed, input } from '@angular/core';
import { output } from 'zod';

@Component({
  selector: 'app-display-field',
  imports: [],
  templateUrl: './display-field.html',
  styleUrl: './display-field.css',
})
export class DisplayField<T extends output<Domain['schema']> = output<Domain['schema']>> {
  /** Label du champ affiché */
  label = input.required<string>();

  /** Valeur du champ à afficher */
  value = input.required<T | undefined>();

  _value = computed(() => {
    const value = this.value();
    if (value === undefined) {
      return '-';
    }
    if (value === true || value === false) {
      return value ? 'Oui' : 'Non';
    }

    return value;
  });
}
