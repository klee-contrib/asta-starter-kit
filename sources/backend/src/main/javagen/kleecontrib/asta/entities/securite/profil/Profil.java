////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite.profil;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Profil des utilisateurs.
 */
@Entity
@Table(name = "PROFILS")
@EntityListeners(AuditingEntityListener.class)
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class Profil {

	/**
	 * Id technique.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "int8", name = "PRO_ID", nullable = false)
	private Long id;

	/**
	 * Libellé du profil.
	 */
	@Column(columnDefinition = "varchar", length = 100, name = "PRO_LIBELLE", nullable = false)
	private String libelle;

	/**
	 * Date de création de l'utilisateur.
	 */
	@CreatedDate
	@Column(columnDefinition = "date", name = "PRO_DATE_CREATION", nullable = false)
	private LocalDateTime dateCreation = LocalDateTime.now();

	/**
	 * Date de modification de l'utilisateur.
	 */
	@LastModifiedDate
	@Column(columnDefinition = "date", name = "PRO_DATE_MODIFICATION")
	private LocalDateTime dateModification = LocalDateTime.now();

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
}
