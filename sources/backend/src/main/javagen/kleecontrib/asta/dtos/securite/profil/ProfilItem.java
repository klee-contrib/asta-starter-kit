////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.profil;

import java.io.Serial;
import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Détail d'un profil en liste.
 */
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class ProfilItem implements Serializable {

	/**
	 * Serial ID.
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * Id technique.
	 * Alias of {@link kleecontrib.asta.entities.securite.profil.Profil#getId() Profil#getId()}
	 */
	@NotNull
	private Long id;

	/**
	 * Libellé du profil.
	 * Alias of {@link kleecontrib.asta.entities.securite.profil.Profil#getLibelle() Profil#getLibelle()}
	 */
	@NotNull
	@Size(max = 100)
	private String libelle;

	/**
	 * Nombre d'utilisateurs affectés au profil.
	 */
	@NotNull
	private Long nombreUtilisateurs;

	/**
	 * Getter for id.
	 *
	 * @return value of {@link #id id}.
	 */
	public Long getId() {
		return this.id;
	}

	/**
	 * Getter for libelle.
	 *
	 * @return value of {@link #libelle libelle}.
	 */
	public String getLibelle() {
		return this.libelle;
	}

	/**
	 * Getter for nombreUtilisateurs.
	 *
	 * @return value of {@link #nombreUtilisateurs nombreUtilisateurs}.
	 */
	public Long getNombreUtilisateurs() {
		return this.nombreUtilisateurs;
	}

	/**
	 * Set the value of {@link #id id}.
	 * @param id value to set.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Set the value of {@link #libelle libelle}.
	 * @param libelle value to set.
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Set the value of {@link #nombreUtilisateurs nombreUtilisateurs}.
	 * @param nombreUtilisateurs value to set.
	 */
	public void setNombreUtilisateurs(Long nombreUtilisateurs) {
		this.nombreUtilisateurs = nombreUtilisateurs;
	}
}
