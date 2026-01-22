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
        var properties = new AuthProperties();
        properties.setAuthority(authenticationProperties.issuer().toString());
        properties.setClientId(authenticationProperties.clientId());
        properties.setRequireHttps(authenticationProperties.requireHttps());
        return properties;
    }
}
