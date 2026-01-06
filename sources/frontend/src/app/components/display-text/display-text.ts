import { Component, input } from '@angular/core';

@Component({
  selector: 'app-display-text',
  imports: [],
  templateUrl: './display-text.html',
  styleUrl: './display-text.css',
})
export class DisplayText {
  label = input.required<string>();
  value = input.required<string | undefined>();
}
