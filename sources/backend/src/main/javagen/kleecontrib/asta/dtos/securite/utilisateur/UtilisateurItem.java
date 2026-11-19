////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.utilisateur;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import kleecontrib.asta.enums.securite.TypeUtilisateurCode;

/**
 * Détail d'un utilisateur en liste.
 */
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public record UtilisateurItem(
	@NotNull Long id,
	@NotNull @Size(max = 100) String nom,
	@NotNull @Size(max = 100) String prenom,
	@NotNull String email,
	@NotNull TypeUtilisateurCode typeUtilisateurCode
) {
}
