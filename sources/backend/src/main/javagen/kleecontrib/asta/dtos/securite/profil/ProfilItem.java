////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.profil;

import java.io.Serial;
import java.io.Serializable;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	 * Alias of {@link kleecontrib.asta.dtos.securite.profil.ProfilItemRead#getNombreUtilisateurs() ProfilItemRead#getNombreUtilisateurs()}
	 */
	@NotNull
	private Long nombreUtilisateurs;

	/**
	 * No arg constructor.
	 */
	public ProfilItem() {
		// No arg constructor
	}

	/**
	 * Crée une nouvelle instance de 'ProfilItem'.
	 * @param profilItemRead Instance de 'ProfilItemRead'.
	 *
	 * @return Une nouvelle instance de 'ProfilItem'.
	 */
	public ProfilItem(ProfilItemRead profilItemRead) {
		SecuriteProfilDTOMappers.mapProfilItem(profilItemRead, this);
	}

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
