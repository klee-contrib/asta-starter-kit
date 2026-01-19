import { AuthConfig } from 'angular-oauth2-oidc';

export const authCodeFlowConfig: AuthConfig = {
  issuer: 'http://localhost:8090/realms/asta',
  redirectUri: globalThis.location.origin,
  clientId: 'asta',
  responseType: 'code',
  scope: 'openid profile email',
  showDebugInformation: true,
};
