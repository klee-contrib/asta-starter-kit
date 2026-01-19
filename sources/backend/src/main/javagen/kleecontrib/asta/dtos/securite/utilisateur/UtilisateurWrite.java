////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.utilisateur;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import kleecontrib.asta.enums.securite.TypeUtilisateurCode;

/**
 * Détail d'un utilisateur en écriture.
 */
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class UtilisateurWrite implements Serializable {

	/**
	 * Serial ID.
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * Nom de l'utilisateur.
	 * Alias of {@link kleecontrib.asta.dtos.securite.utilisateur.UtilisateurCommand#getNom() UtilisateurCommand#getNom()}
	 */
	@NotNull
	@Size(max = 100)
	private String nom;

	/**
	 * Nom de l'utilisateur.
	 * Alias of {@link kleecontrib.asta.dtos.securite.utilisateur.UtilisateurCommand#getPrenom() UtilisateurCommand#getPrenom()}
	 */
	@NotNull
	@Size(max = 100)
	private String prenom;

	/**
	 * Email de l'utilisateur.
	 * Alias of {@link kleecontrib.asta.dtos.securite.utilisateur.UtilisateurCommand#getEmail() UtilisateurCommand#getEmail()}
	 */
	@NotNull
	private String email;

	/**
	 * Age de l'utilisateur.
	 * Alias of {@link kleecontrib.asta.dtos.securite.utilisateur.UtilisateurCommand#getDateNaissance() UtilisateurCommand#getDateNaissance()}
	 */
	private LocalDate dateNaissance;

	/**
	 * Adresse de l'utilisateur.
	 * Alias of {@link kleecontrib.asta.dtos.securite.utilisateur.UtilisateurCommand#getAdresse() UtilisateurCommand#getAdresse()}
	 */
	@Size(max = 100)
	private String adresse;

	/**
	 * Si l'utilisateur est actif.
	 * Alias of {@link kleecontrib.asta.dtos.securite.utilisateur.UtilisateurCommand#getActif() UtilisateurCommand#getActif()}
	 */
	@NotNull
	private Boolean actif = true;

	/**
	 * Profil de l'utilisateur.
	 * Alias of {@link kleecontrib.asta.dtos.securite.utilisateur.UtilisateurCommand#getProfilId() UtilisateurCommand#getProfilId()}
	 */
	@NotNull
	private Long profilId;

	/**
	 * Type d'utilisateur.
	 * Alias of {@link kleecontrib.asta.dtos.securite.utilisateur.UtilisateurCommand#getTypeUtilisateurCode() UtilisateurCommand#getTypeUtilisateurCode()}
	 */
	@NotNull
	private TypeUtilisateurCode typeUtilisateurCode = TypeUtilisateurCode.GEST;

	/**
	 * Getter for nom.
	 *
	 * @return value of {@link #nom nom}.
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Getter for prenom.
	 *
	 * @return value of {@link #prenom prenom}.
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Getter for email.
	 *
	 * @return value of {@link #email email}.
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * Getter for dateNaissance.
	 *
	 * @return value of {@link #dateNaissance dateNaissance}.
	 */
	public LocalDate getDateNaissance() {
		return this.dateNaissance;
	}

	/**
	 * Getter for adresse.
	 *
	 * @return value of {@link #adresse adresse}.
	 */
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * Getter for actif.
	 *
	 * @return value of {@link #actif actif}.
	 */
	public Boolean getActif() {
		return this.actif;
	}

	/**
	 * Getter for profilId.
	 *
	 * @return value of {@link #profilId profilId}.
	 */
	public Long getProfilId() {
		return this.profilId;
	}

	/**
	 * Getter for typeUtilisateurCode.
	 *
	 * @return value of {@link #typeUtilisateurCode typeUtilisateurCode}.
	 */
	public TypeUtilisateurCode getTypeUtilisateurCode() {
		return this.typeUtilisateurCode;
	}

	/**
	 * Set the value of {@link #nom nom}.
	 * @param nom value to set.
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Set the value of {@link #prenom prenom}.
	 * @param prenom value to set.
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Set the value of {@link #email email}.
	 * @param email value to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Set the value of {@link #dateNaissance dateNaissance}.
	 * @param dateNaissance value to set.
	 */
	public void setDateNaissance(LocalDate dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	/**
	 * Set the value of {@link #adresse adresse}.
	 * @param adresse value to set.
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Set the value of {@link #actif actif}.
	 * @param actif value to set.
	 */
	public void setActif(Boolean actif) {
		this.actif = actif;
	}

	/**
	 * Set the value of {@link #profilId profilId}.
	 * @param profilId value to set.
	 */
	public void setProfilId(Long profilId) {
		this.profilId = profilId;
	}

	/**
	 * Set the value of {@link #typeUtilisateurCode typeUtilisateurCode}.
	 * @param typeUtilisateurCode value to set.
	 */
	public void setTypeUtilisateurCode(TypeUtilisateurCode typeUtilisateurCode) {
		this.typeUtilisateurCode = typeUtilisateurCode;
	}

	/**
	 * Mappe 'UtilisateurWrite' vers 'UtilisateurCommand'.
	 * @param target Instance pré-existante de 'UtilisateurCommand'. Une nouvelle instance sera créée si non spécifié.
	 *
	 * @return Une instance de 'UtilisateurCommand'.
	 */
	public UtilisateurCommand toUtilisateurCommand(UtilisateurCommand target) {
		return SecuriteUtilisateurDTOMappers.toUtilisateurCommand(this, target);
	}
}
