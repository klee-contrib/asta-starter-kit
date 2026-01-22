package kleecontrib.asta.queries;

import java.util.Collection;

import kleecontrib.asta.dtos.securite.auth.AuthProperties;

/**
 * Service pour gérer l'authentification et récupérer l'utilisateur courant.
 */
public interface AuthenticationService {

    /**
     * Récupère l'ensemble des propriétés nécessaires à la connexion OAuth2.
     *
     * @return Informations relatives à la connexion (issuer et clientId).
     */
    AuthProperties getAuthenticationProperties();
}
