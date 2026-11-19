////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.utilisateur;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import kleecontrib.asta.enums.securite.TypeUtilisateurCode;

/**
 * Détail d'un utilisateur en lecture.
 */
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public record UtilisateurRead(
	@NotNull Long id,
	@NotNull @Size(max = 100) String nom,
	@NotNull @Size(max = 100) String prenom,
	@NotNull String email,
	LocalDate dateNaissance,
	@Size(max = 100) String adresse,
	@NotNull Boolean actif,
	@NotNull Long profilId,
	@NotNull TypeUtilisateurCode typeUtilisateurCode,
	@NotNull LocalDateTime dateCreation,
	LocalDateTime dateModification
) {
}
