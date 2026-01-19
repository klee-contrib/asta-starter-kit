////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.utilisateur;

import java.io.Serial;
import java.io.Serializable;

import jakarta.annotation.Generated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import kleecontrib.asta.entities.securite.utilisateur.SecuriteUtilisateurMappers;
import kleecontrib.asta.entities.securite.utilisateur.Utilisateur;
import kleecontrib.asta.enums.securite.TypeUtilisateurCode;

/**
 * Détail d'un utilisateur en liste.
 */
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class UtilisateurItem implements Serializable {

	/**
	 * Serial ID.
	 */
	@Serial
	private static final long serialVersionUID = 1L;

	/**
	 * Id de l'utilisateur.
	 * Alias of {@link kleecontrib.asta.entities.securite.utilisateur.Utilisateur#getId() Utilisateur#getId()}
	 */
	@NotNull
	private Long id;

	/**
	 * Nom de l'utilisateur.
	 * Alias of {@link kleecontrib.asta.entities.securite.utilisateur.Utilisateur#getNom() Utilisateur#getNom()}
	 */
	@NotNull
	@Size(max = 100)
	private String nom;

	/**
	 * Nom de l'utilisateur.
	 * Alias of {@link kleecontrib.asta.entities.securite.utilisateur.Utilisateur#getPrenom() Utilisateur#getPrenom()}
	 */
	@NotNull
	@Size(max = 100)
	private String prenom;

	/**
	 * Email de l'utilisateur.
	 * Alias of {@link kleecontrib.asta.entities.securite.utilisateur.Utilisateur#getEmail() Utilisateur#getEmail()}
	 */
	@NotNull
	private String email;

	/**
	 * Type d'utilisateur.
	 * Alias of {@link kleecontrib.asta.entities.securite.utilisateur.Utilisateur#getTypeUtilisateur() Utilisateur#getTypeUtilisateur()}
	 */
	@NotNull
	private TypeUtilisateurCode typeUtilisateurCode = TypeUtilisateurCode.GEST;

	/**
	 * No arg constructor.
	 */
	public UtilisateurItem() {
		// No arg constructor
	}

	/**
	 * Crée une nouvelle instance de 'UtilisateurItem'.
	 * @param utilisateur Instance de 'Utilisateur'.
	 *
	 * @return Une nouvelle instance de 'UtilisateurItem'.
	 */
	public UtilisateurItem(Utilisateur utilisateur) {
		SecuriteUtilisateurMappers.mapUtilisateurItem(utilisateur, this);
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
	 * Getter for typeUtilisateurCode.
	 *
	 * @return value of {@link #typeUtilisateurCode typeUtilisateurCode}.
	 */
	public TypeUtilisateurCode getTypeUtilisateurCode() {
		return this.typeUtilisateurCode;
	}

	/**
	 * Set the value of {@link #id id}.
	 * @param id value to set.
	 */
	public void setId(Long id) {
		this.id = id;
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
	 * Set the value of {@link #typeUtilisateurCode typeUtilisateurCode}.
	 * @param typeUtilisateurCode value to set.
	 */
	public void setTypeUtilisateurCode(TypeUtilisateurCode typeUtilisateurCode) {
		this.typeUtilisateurCode = typeUtilisateurCode;
	}
}
