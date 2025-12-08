import { Component, computed, inject, input } from '@angular/core';
import { Entity } from '@focus4/entities';
import { EntityStore } from '../../services/entity/types';
import { ReferenceLoaderService, ReferenceName } from '../../services/reference/references.service';

@Component({
  selector: 'app-display-field',
  imports: [],
  templateUrl: './display-field.html',
  styleUrl: './display-field.css',
})
export class DisplayField {
  label = input.required<string>();
  value = input.required<string | undefined>();
}
