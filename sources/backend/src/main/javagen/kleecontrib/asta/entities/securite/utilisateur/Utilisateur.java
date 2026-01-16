////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite.utilisateur;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;

import kleecontrib.asta.entities.securite.profil.Profil;
import kleecontrib.asta.entities.securite.TypeUtilisateur;
import kleecontrib.asta.enums.securite.utilisateur.TypeUtilisateurCode;

/**
 * Utilisateur de l'application.
 */
@Entity
@EntityListeners(AuditingEntityListener.class)
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
@Table(name = "UTILISATEURS", uniqueConstraints = {@UniqueConstraint(columnNames = {"UTI_EMAIL"})})
public class Utilisateur {

	/**
	 * Id de l'utilisateur.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "UTI_ID", nullable = false, columnDefinition = "int8")
	private Long id;

	/**
	 * Nom de l'utilisateur.
	 */
	@Column(name = "UTI_NOM", nullable = false, length = 100, columnDefinition = "varchar")
	private String nom;

	/**
	 * Nom de l'utilisateur.
	 */
	@Column(name = "UTI_PRENOM", nullable = false, length = 100, columnDefinition = "varchar")
	private String prenom;

	/**
	 * Email de l'utilisateur.
	 */
	@Column(name = "UTI_EMAIL", nullable = false, columnDefinition = "varchar")
	private String email;

	/**
	 * Age de l'utilisateur.
	 */
	@Column(name = "UTI_DATE_NAISSANCE", columnDefinition = "date")
	private LocalDate dateNaissance;

	/**
	 * Adresse de l'utilisateur.
	 */
	@Column(name = "UTI_ADRESSE", length = 100, columnDefinition = "varchar")
	private String adresse;

	/**
	 * Si l'utilisateur est actif.
	 */
	@Column(name = "UTI_ACTIF", nullable = false, columnDefinition = "boolean")
	private Boolean actif = true;

	/**
	 * Profil de l'utilisateur.
	 */
	@JoinColumn(name = "PRO_ID", referencedColumnName = "PRO_ID")
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = Profil.class)
	private Profil profil;

	/**
	 * Type d'utilisateur.
	 */
	@JoinColumn(name = "TUT_CODE", referencedColumnName = "TUT_CODE")
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = TypeUtilisateur.class)
	private TypeUtilisateur typeUtilisateur = new TypeUtilisateur(TypeUtilisateurCode.GEST);

	/**
	 * Nom du fichier de la photo de l'utilisateur, s'il en a une.
	 */
	@Column(name = "UTI_NOM_FICHIER_PHOTO", length = 100, columnDefinition = "varchar")
	private String nomFichierPhoto;

	/**
	 * Date de création de l'utilisateur.
	 */
	@CreatedDate
	@Column(name = "UTI_DATE_CREATION", nullable = false, columnDefinition = "date")
	private LocalDateTime dateCreation = LocalDateTime.now();

	/**
	 * Date de modification de l'utilisateur.
	 */
	@LastModifiedDate
	@Column(name = "UTI_DATE_MODIFICATION", columnDefinition = "date")
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
	 * Getter for profil.
	 *
	 * @return value of {@link #profil profil}.
	 */
	public Profil getProfil() {
		return this.profil;
	}

	/**
	 * Getter for typeUtilisateur.
	 *
	 * @return value of {@link #typeUtilisateur typeUtilisateur}.
	 */
	public TypeUtilisateur getTypeUtilisateur() {
		return this.typeUtilisateur;
	}

	/**
	 * Getter for nomFichierPhoto.
	 *
	 * @return value of {@link #nomFichierPhoto nomFichierPhoto}.
	 */
	public String getNomFichierPhoto() {
		return this.nomFichierPhoto;
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
	 * Set the value of {@link #profil profil}.
	 * @param profil value to set.
	 */
	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	/**
	 * Set the value of {@link #typeUtilisateur typeUtilisateur}.
	 * @param typeUtilisateur value to set.
	 */
	public void setTypeUtilisateur(TypeUtilisateur typeUtilisateur) {
		this.typeUtilisateur = typeUtilisateur;
	}

	/**
	 * Set the value of {@link #nomFichierPhoto nomFichierPhoto}.
	 * @param nomFichierPhoto value to set.
	 */
	public void setNomFichierPhoto(String nomFichierPhoto) {
		this.nomFichierPhoto = nomFichierPhoto;
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
