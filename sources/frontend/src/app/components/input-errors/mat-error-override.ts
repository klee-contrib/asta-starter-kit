import { Component, input } from '@angular/core';
import { FormControl } from '@angular/forms';
import { MatError } from '@angular/material/form-field';

@Component({
  selector: 'mat-error',
  templateUrl: './mat-error-override.html',
})
export class MatErrorOverride extends MatError {
  readonly control = input.required<FormControl>();
}
