import { Component, inject, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { OAuthService } from 'angular-oauth2-oidc';
import { authCodeFlowConfig } from '../auth';
import { AuthService } from '../auth/auth.service';
import { ProfilService } from '../services/securite/profil';
import { ProfilRead } from '../model/securite/profil/profil-read';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App implements OnInit {
  protected readonly title = signal('asta-starter-kit');
  protected readonly authService = inject(AuthService);
  protected readonly profilService = inject(ProfilService);
  protected profils: ProfilRead[] = [];

  ngOnInit() {
    this.authService.login();
    this.profilService.getProfils().subscribe((p) => (this.profils = p));
  }
}
