////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

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
	public static final Droit CREATE = new Droit(DroitCode.CREATE);

	@Transient
	public static final Droit DELETE = new Droit(DroitCode.DELETE);

	@Transient
	public static final Droit READ = new Droit(DroitCode.READ);

	@Transient
	public static final Droit UPDATE = new Droit(DroitCode.UPDATE);

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
	 * Enum constructor.
	 * @param code Code dont on veut obtenir l'instance.
	 */
	public Droit(DroitCode code) {
		this.code = code;
		switch(code) {
			case CREATE:
				this.libelle = "Création";
				this.typeDroit = TypeDroit.WRITE;
				break;
			case DELETE:
				this.libelle = "Suppression";
				this.typeDroit = TypeDroit.ADMIN;
				break;
			case READ:
				this.libelle = "Lecture";
				this.typeDroit = TypeDroit.READ;
				break;
			case UPDATE:
				this.libelle = "Mise à jour";
				this.typeDroit = TypeDroit.WRITE;
				break;
		}
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
}
