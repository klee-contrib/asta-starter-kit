package kleecontrib.asta.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@ConfigurationProperties("auth")
public record AuthenticationProperties(
                URI issuer,
                String clientId,
                boolean requireHttps) {
}
