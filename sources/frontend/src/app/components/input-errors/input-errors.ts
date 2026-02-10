import { Component, input } from '@angular/core';
import { FormControl } from '@angular/forms';

@Component({
  selector: 'app-input-errors',
  templateUrl: './input-errors.html',
})
export class InputErrors {
  readonly control = input.required<FormControl>();
}
