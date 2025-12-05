////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite.profil;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Profil des utilisateurs.
 */
@Entity
@Table(name = "PROFILS")
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class Profil {

	/**
	 * Id technique.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PRO_ID", nullable = false, columnDefinition = "int8")
	private Long id;

	/**
	 * Libellé du profil.
	 */
	@Column(name = "PRO_LIBELLE", nullable = false, length = 100, columnDefinition = "varchar")
	private String libelle;

	/**
	 * Date de création de l'utilisateur.
	 */
	@Column(name = "PRO_DATE_CREATION", nullable = false, columnDefinition = "date")
	private LocalDateTime dateCreation = LocalDateTime.now();

	/**
	 * Date de modification de l'utilisateur.
	 */
	@Column(name = "PRO_DATE_MODIFICATION", columnDefinition = "date")
	private LocalDateTime dateModification;

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
	 * Mappe 'Profil' vers 'Profil'.
	 * @param target Instance pré-existante de 'Profil'. Une nouvelle instance sera créée si non spécifié.
	 *
	 * @return Une instance de 'Profil'.
	 */
	public Profil toProfil(Profil target) {
		return SecuriteProfilMappers.toProfil(this, target);
	}
}
