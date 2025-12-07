import { Component, computed, input } from '@angular/core';
import { Entity, EntityToType } from '@focus4/entities';

@Component({
  selector: 'app-display-field',
  imports: [],
  templateUrl: './display-field.html',
  styleUrl: './display-field.css',
})
export class DisplayField<E extends Entity> {
  fieldName = input.required<keyof E>();
  entity = input.required<E>();
  value = input<EntityToType<E>>();

  field = computed(() => this.entity()[this.fieldName()]);
  fieldValue = computed(() => {
    const value = this.value();
    if (value) {
      return value[this.fieldName()];
    }
    return undefined;
  });
}
