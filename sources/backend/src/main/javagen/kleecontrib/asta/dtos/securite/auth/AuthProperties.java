////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.auth;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.Size;

/**
 * Informations relatives à l'authentification.
 */
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public record AuthProperties(
	@Size(max = 100) String authority,
	@Size(max = 100) String clientId,
	Boolean requireHttps
) {
}
