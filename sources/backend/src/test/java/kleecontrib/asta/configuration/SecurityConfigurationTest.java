package kleecontrib.asta.configuration;

import kleecontrib.asta.configuration.properties.AuthenticationProperties;
import org.junit.jupiter.api.Test;
import org.springframework.boot.security.autoconfigure.SecurityProperties;
import org.springframework.web.cors.CorsConfigurationSource;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;

class SecurityConfigurationTest {

    private final SecurityConfiguration configuration =
            new SecurityConfiguration(new AuthenticationProperties(
                    URI.create("http://localhost:8090/realms/asta"), "asta", false));

    @Test
    void corsConfigurationSourceUsesSpringBoot41SecurityProperties() {
        CorsConfigurationSource corsConfigurationSource =
                configuration.corsConfigurationSource(new SecurityProperties());

        assertThat(corsConfigurationSource).isNotNull();
        assertThat(SecurityProperties.class.getPackageName())
                .isEqualTo("org.springframework.boot.security.autoconfigure");
    }
}
