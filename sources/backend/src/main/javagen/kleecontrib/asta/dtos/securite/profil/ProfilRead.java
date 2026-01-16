////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.profil;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;

import javax.annotation.Generated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.Valid;

import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurItem;
import kleecontrib.asta.entities.securite.profil.Profil;
import kleecontrib.asta.entities.securite.profil.SecuriteProfilMappers;
import kleecontrib.asta.enums.securite.DroitCode;

/**
 * Détail d'un profil en lecture.
 */
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class ProfilRead implements Serializable {

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
	 * Date de création de l'utilisateur.
	 * Alias of {@link kleecontrib.asta.entities.securite.profil.Profil#getDateCreation() Profil#getDateCreation()}
	 */
	@NotNull
	private LocalDateTime dateCreation;

	/**
	 * Date de modification de l'utilisateur.
	 * Alias of {@link kleecontrib.asta.entities.securite.profil.Profil#getDateModification() Profil#getDateModification()}
	 */
	private LocalDateTime dateModification;

	/**
	 * Code du droit.
	 * Alias of {@link kleecontrib.asta.entities.securite.Droit#getCode() Droit#getCode()}
	 */
	@NotNull
	@Size(max = 10)
	private Collection<DroitCode> droitCodes;

	/**
	 * Utilisateurs ayant ce profil.
	 */
	@Valid
	@NotNull
	private Collection<UtilisateurItem> utilisateurs;

	/**
	 * No arg constructor.
	 */
	public ProfilRead() {
		// No arg constructor
	}

	/**
	 * Crée une nouvelle instance de 'ProfilRead'.
	 * @param profil Instance de 'Profil'.
	 * @param droitCodes Code du droit.
	 * @param utilisateurs Utilisateurs ayant ce profil.
	 *
	 * @return Une nouvelle instance de 'ProfilRead'.
	 */
	public ProfilRead(Profil profil, Collection<DroitCode> droitCodes, Collection<UtilisateurItem> utilisateurs) {
		SecuriteProfilMappers.mapProfilRead(profil, droitCodes, utilisateurs, this);
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
	 * Getter for dateCreation.
	 *
	 * @return value of {@link #dateCreation dateCreation}.
	 */
	public LocalDateTime getDateCreation() {
		return this.dateCreation;
	}

	/**
	 * Getter for dateModification.
	 *
	 * @return value of {@link #dateModification dateModification}.
	 */
	public LocalDateTime getDateModification() {
		return this.dateModification;
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
	 * Getter for utilisateurs.
	 *
	 * @return value of {@link #utilisateurs utilisateurs}.
	 */
	public Collection<UtilisateurItem> getUtilisateurs() {
		return this.utilisateurs;
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
	 * Set the value of {@link #dateCreation dateCreation}.
	 * @param dateCreation value to set.
	 */
	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	/**
	 * Set the value of {@link #dateModification dateModification}.
	 * @param dateModification value to set.
	 */
	public void setDateModification(LocalDateTime dateModification) {
		this.dateModification = dateModification;
	}

	/**
	 * Set the value of {@link #droitCodes droitCodes}.
	 * @param droitCodes value to set.
	 */
	public void setDroitCodes(Collection<DroitCode> droitCodes) {
		this.droitCodes = droitCodes;
	}

	/**
	 * Set the value of {@link #utilisateurs utilisateurs}.
	 * @param utilisateurs value to set.
	 */
	public void setUtilisateurs(Collection<UtilisateurItem> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
}
