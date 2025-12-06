import { Component, inject, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { ProfilService } from '../services/securite/profil';
import { Menu } from './layout/menu/menu';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Menu],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App implements OnInit {
  protected readonly title = signal('asta-starter-kit');
  protected readonly authService = inject(AuthService);
  protected readonly profilService = inject(ProfilService);
  isLoggedIn() {
    return this.authService.isLoggedIn();
  }
  ngOnInit() {
    this.authService.login();
  }
}
