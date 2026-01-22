package kleecontrib.asta.api.securite.auth;

import kleecontrib.asta.dtos.securite.auth.AuthProperties;
import kleecontrib.asta.queries.AuthenticationService;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implémentation du contrôleur REST pour la gestion de l'authentification.
 * Fournit les informations nécessaires à la connexion OAuth2 et les
 * informations de l'utilisateur connecté.
 * <p>
 * Ce contrôleur délègue toute la logique au service AuthenticationService.
 */
@RestController
public class AuthControllerImpl implements AuthController {

    private final AuthenticationService authenticationService;

    public AuthControllerImpl(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * Récupère l'ensemble des propriétés nécessaires à la connexion OAuth2.
     * Cet endpoint est accessible sans authentification.
     *
     * @return Informations relatives à la connexion (issuer et clientId).
     */
    @Override
    public AuthProperties authenticationProperties() {
        return authenticationService.getAuthenticationProperties();
    }
}
