import { Component, input } from '@angular/core';
import { FieldTree } from '@angular/forms/signals';

@Component({
  selector: 'app-signal-input-errors',
  templateUrl: './signal-input-errors.html',
  imports: [],
})
export class SignalInputErrors {
  readonly formField = input.required<FieldTree<string, string, 'writable'>>();
}
