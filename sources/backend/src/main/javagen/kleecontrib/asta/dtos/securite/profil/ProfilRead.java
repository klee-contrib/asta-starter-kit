////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.profil;

import java.time.LocalDateTime;
import java.util.Collection;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.Valid;

import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurItem;
import kleecontrib.asta.enums.securite.DroitCode;

/**
 * Détail d'un profil en lecture.
 */
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public record ProfilRead(
	@NotNull Long id,
	@NotNull @Size(max = 100) String libelle,
	@NotNull LocalDateTime dateCreation,
	LocalDateTime dateModification,
	@NotNull @Size(max = 10) Collection<DroitCode> droitCodes,
	@NotNull @Valid Collection<UtilisateurItem> utilisateurs
) {
}
