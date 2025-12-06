import { OAuthService } from 'angular-oauth2-oidc';
import { authCodeFlowConfig } from '.';
import { Injectable } from '@angular/core';

@Injectable({ providedIn: 'root' })
export class AuthService {
  constructor(protected readonly oauthService: OAuthService) {}

  async login() {
    this.oauthService.configure(authCodeFlowConfig);
    await this.oauthService.loadDiscoveryDocumentAndTryLogin();
    this.oauthService.setupAutomaticSilentRefresh();
    if (!this.oauthService.hasValidAccessToken()) {
      this.oauthService.initLoginFlow();
    }
  }
}
