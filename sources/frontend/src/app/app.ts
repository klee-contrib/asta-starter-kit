import { Component, inject, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { AuthService } from '../auth/auth.service';
import { Menu } from './layout/menu/menu';
import { Toolbar } from './layout/toolbar/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { ProfilService } from '../services/securite/profil/profil.service';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, Menu, MatSidenavModule, Toolbar],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App implements OnInit {
  protected readonly title = signal('asta-starter-kit');
  protected readonly authService = inject(AuthService);
  protected readonly profilService = inject(ProfilService);
  isLoggedIn = this.authService.isLoggedIn;

  ngOnInit() {
    this.authService.login();
  }
}
