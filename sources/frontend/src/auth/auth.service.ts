import { OAuthService } from 'angular-oauth2-oidc';
import { authCodeFlowConfig } from '.';
import { Injectable, signal } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AuthService {
  constructor(protected readonly oauthService: OAuthService) {}
  private readonly _isLoggedIn = signal(false);
  isLoggedIn = this._isLoggedIn.asReadonly();

  async login() {
    this.oauthService.configure(authCodeFlowConfig);
    await this.oauthService.loadDiscoveryDocumentAndTryLogin();
    this.oauthService.setupAutomaticSilentRefresh();
    if (!this.oauthService.hasValidAccessToken()) {
      this.oauthService.initLoginFlow();
    }
    this._isLoggedIn.set(this.oauthService.hasValidAccessToken());
  }

  logout() {
    this.oauthService.logOut();
  }
}
