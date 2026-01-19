////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.profil;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collection;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import kleecontrib.asta.enums.securite.DroitCode;

/**
 * Détail d'un profil en écriture.
 */
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class ProfilWrite implements Serializable {

	/**
	 * Serial ID.
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * Libellé du profil.
	 * Alias of {@link kleecontrib.asta.dtos.securite.profil.ProfilCommand#getLibelle() ProfilCommand#getLibelle()}
	 */
	@NotNull
	@Size(max = 100)
	private String libelle;

	/**
	 * Code du droit.
	 * Alias of {@link kleecontrib.asta.dtos.securite.profil.ProfilCommand#getDroitCodes() ProfilCommand#getDroitCodes()}
	 */
	@NotNull
	@Size(max = 10)
	private Collection<DroitCode> droitCodes;

	/**
	 * Getter for libelle.
	 *
	 * @return value of {@link #libelle libelle}.
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Getter for droitCodes.
	 *
	 * @return value of {@link #droitCodes droitCodes}.
	 */
	public Collection<DroitCode> getDroitCodes() {
		return this.droitCodes;
	}

	/**
	 * Set the value of {@link #libelle libelle}.
	 * @param libelle value to set.
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Set the value of {@link #droitCodes droitCodes}.
	 * @param droitCodes value to set.
	 */
	public void setDroitCodes(Collection<DroitCode> droitCodes) {
		this.droitCodes = droitCodes;
	}

	/**
	 * Mappe 'ProfilWrite' vers 'ProfilCommand'.
	 * @param target Instance pré-existante de 'ProfilCommand'. Une nouvelle instance sera créée si non spécifié.
	 *
	 * @return Une instance de 'ProfilCommand'.
	 */
	public ProfilCommand toProfilCommand(ProfilCommand target) {
		return SecuriteProfilDTOMappers.toProfilCommand(this, target);
	}
}
