import { OAuthService } from 'angular-oauth2-oidc';
import { authCodeFlowConfig } from '.';
import { inject, Injectable, signal } from '@angular/core';
import { AuthService } from '../services/securite/auth/auth.service';
import { lastValueFrom } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class UserService {
  constructor(protected readonly oauthService: OAuthService) {}
  private readonly authService = inject(AuthService);
  private readonly _isLoggedIn = signal(false);
  isLoggedIn = this._isLoggedIn.asReadonly();

  async login() {
    const authProperties = await lastValueFrom(this.authService.authenticationProperties());
    authCodeFlowConfig.issuer = authProperties?.authority;
    authCodeFlowConfig.clientId = authProperties?.clientId;
    authCodeFlowConfig.requireHttps = authProperties.requireHttps;
    this.oauthService.configure(authCodeFlowConfig);
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
