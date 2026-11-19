package kleecontrib.asta.queries;

import org.springframework.stereotype.Service;

import kleecontrib.asta.configuration.properties.AuthenticationProperties;
import kleecontrib.asta.dtos.securite.auth.AuthProperties;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AuthenticationProperties authenticationProperties;

    public AuthenticationServiceImpl(AuthenticationProperties authenticationProperties) {
        this.authenticationProperties = authenticationProperties;
    }

    @Override
    public AuthProperties getAuthenticationProperties() {
        return new AuthProperties(authenticationProperties.issuer().toString(), authenticationProperties.clientId(),
                authenticationProperties.requireHttps());
    }
}
