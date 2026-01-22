////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.api.securite.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.annotation.Generated;

import kleecontrib.asta.dtos.securite.auth.AuthProperties;

@RequestMapping("api/auth")
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public interface AuthController {

	/**
	 * Récupère l'ensemble des propriétés nécessaires à la connexion.
	 *
	 * @return Informations relatives à la connexion.
	 */
	@GetMapping(path = "authentication-properties")
	AuthProperties authenticationProperties();
}
