import { Component, OnInit, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { OAuthService } from 'angular-oauth2-oidc';
import { authCodeFlowConfig } from '../auth';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet],
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App implements OnInit {
  protected readonly title = signal('asta-starter-kit');
  constructor(protected readonly oauthService: OAuthService) {}
  ngOnInit() {
    this.login();
  }
  async login() {
    this.oauthService.configure(authCodeFlowConfig);
    await this.oauthService.loadDiscoveryDocumentAndTryLogin();
    this.oauthService.initLoginFlow();
  }
}
