package kleecontrib.asta.configuration;

import kleecontrib.asta.configuration.properties.AuthenticationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.security.autoconfigure.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.CrossOriginEmbedderPolicyHeaderWriter;
import org.springframework.security.web.header.writers.CrossOriginResourcePolicyHeaderWriter;
import org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter;
import org.springframework.security.web.header.writers.XXssProtectionHeaderWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Collections;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@ConfigurationPropertiesScan({"kleecontrib.asta.configuration"})
public class SecurityConfiguration {

    private final AuthenticationProperties authenticationProperties;

    public SecurityConfiguration(AuthenticationProperties authenticationProperties) {
        this.authenticationProperties = authenticationProperties;
    }

    /**
     * Configuration des permissions d'accès aux urls, page de login et de logout
     *
     * @param httpSecurity Objet de gestion de la sécurité qui sera complété avec
     *                     nos règles spécifiques
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity, CorsConfigurationSource corsConfigurationSource) {
        String[] csps = new String[]{"default-src 'self' ", "connect-src 'self' " + authenticationProperties.issuer().getAuthority(), "script-src 'self'", "style-src 'self' 'unsafe-inline'", "worker-src 'none'", "frame-src 'none'", "manifest-src 'none'", "media-src 'self'", "object-src 'none'", "require-trusted-types-for 'script'"};
        String csp = String.join("; ", csps);

        httpSecurity //
                .formLogin(AbstractHttpConfigurer::disable)//
                .logout(AbstractHttpConfigurer::disable)//
                .csrf(AbstractHttpConfigurer::disable)//
                .cors(t -> t.configurationSource(corsConfigurationSource))
                .httpBasic(AbstractHttpConfigurer::disable)//
                .oauth2ResourceServer(t -> t.jwt(Customizer.withDefaults())) //
                .authorizeHttpRequests(auth -> auth.requestMatchers("/actuator/**").permitAll()) //
                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/auth/authentication-properties").permitAll()) //
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated()) //
                .headers(headers -> headers //
                        .xssProtection(h -> h.headerValue(XXssProtectionHeaderWriter.HeaderValue.DISABLED)).httpStrictTransportSecurity(Customizer.withDefaults()).contentTypeOptions(Customizer.withDefaults()).crossOriginResourcePolicy(p -> p.policy(CrossOriginResourcePolicyHeaderWriter.CrossOriginResourcePolicy.SAME_ORIGIN)).referrerPolicy(p -> p.policy(ReferrerPolicyHeaderWriter.ReferrerPolicy.SAME_ORIGIN)).crossOriginEmbedderPolicy(p -> p.policy(CrossOriginEmbedderPolicyHeaderWriter.CrossOriginEmbedderPolicy.REQUIRE_CORP)).contentSecurityPolicy(p -> p.policyDirectives(csp))

                );

        return httpSecurity.build();
    }

    @Bean
    CorsConfigurationSource corsConfigurationSource(SecurityProperties securityProperties) {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Collections.singletonList(authenticationProperties.issuer().getHost()));
        configuration.setAllowedMethods(Collections.singletonList("*"));
        configuration.setAllowedHeaders(Collections.singletonList("*"));
        configuration.setExposedHeaders(Collections.singletonList("*"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
