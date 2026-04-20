////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite;

import java.util.List;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import kleecontrib.asta.enums.securite.DroitCode;

/**
 * Droits de l'application.
 */
@Entity
@Immutable
@Table(name = "DROITS")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class Droit {

	@Transient
	public static final Droit CREATE = new Droit(DroitCode.CREATE, "Création", TypeDroit.WRITE);

	@Transient
	public static final Droit DELETE = new Droit(DroitCode.DELETE, "Suppression", TypeDroit.ADMIN);

	@Transient
	public static final Droit READ = new Droit(DroitCode.READ, "Lecture", TypeDroit.READ);

	@Transient
	public static final Droit UPDATE = new Droit(DroitCode.UPDATE, "Mise à jour", TypeDroit.WRITE);

	/**
	 * Liste de toutes les valeurs de l'énumération Droit.
	 */
	public static final List<Droit> VALUES = List.of(CREATE, DELETE, READ, UPDATE);

	/**
	 * Code du droit.
	 */
	@Id
	@Enumerated(EnumType.STRING)
	@Column(name = "DRO_CODE", nullable = false, length = 10, columnDefinition = "varchar")
	private DroitCode code;

	/**
	 * Libellé du droit.
	 */
	@Column(name = "DRO_LIBELLE", nullable = false, length = 100, columnDefinition = "varchar")
	private String libelle;

	/**
	 * Type de profil pouvant faire l'action.
	 */
	@JoinColumn(name = "TDR_CODE", referencedColumnName = "TDR_CODE")
	@ManyToOne(fetch = FetchType.LAZY, optional = false, targetEntity = TypeDroit.class)
	private TypeDroit typeDroit;

	/**
	 * No arg constructor.
	 */
	public Droit() {
		// No arg constructor
	}

	/**
	 * All args constructor for 'Droit'.
	 * @param code Code du droit.
	 * @param libelle Libellé du droit.
	 * @param typeDroit Type de profil pouvant faire l'action.
	 */
	private Droit(DroitCode code, String libelle, TypeDroit typeDroit) {
		this.code = code;
		this.libelle = libelle;
		this.typeDroit = typeDroit;
	}

	/**
	 * Getter for code.
	 *
	 * @return value of {@link #code code}.
	 */
	public DroitCode getCode() {
		return this.code;
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
	 * Getter for typeDroit.
	 *
	 * @return value of {@link #typeDroit typeDroit}.
	 */
	public TypeDroit getTypeDroit() {
		return this.typeDroit;
	}

	/**
	 * Retourne la valeur de l'énumération pour la clé spécifiée.
	 * @param code La clé de l'énumération pour laquelle obtenir la valeur.
	 *
	 * @return La valeur de l'énumération correspondant à la clé 'Code'.
	 */
	public static Droit getValue(DroitCode code) {
		return switch (code) {
			case CREATE -> CREATE;
			case DELETE -> DELETE;
			case READ -> READ;
			case UPDATE -> UPDATE;
		};
	}
}
