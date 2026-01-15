import { NgOptimizedImage } from '@angular/common';
import { Component } from '@angular/core';
import { MatRippleModule } from '@angular/material/core';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-menu',
  imports: [RouterModule, MatRippleModule, MatIconModule, NgOptimizedImage],
  templateUrl: './menu.html',
  styleUrl: './menu.css',
})
export class Menu {}
