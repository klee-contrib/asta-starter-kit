import { Component, input } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatError } from '@angular/material/form-field';

@Component({
  selector: 'app-input-errors',
  imports: [MatError],
  templateUrl: './input-errors.html',
  styleUrl: './input-errors.css',
})
export class InputErrors {
  readonly control = input.required<FormControl>();
}
