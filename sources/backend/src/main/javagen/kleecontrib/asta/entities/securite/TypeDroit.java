////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Immutable;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

import kleecontrib.asta.enums.securite.TypeDroitCode;

/**
 * Type de droit.
 */
@Entity
@Immutable
@Table(name = "TYPE_DROITS")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class TypeDroit {

	@Transient
	public static final TypeDroit ADMIN = new TypeDroit(TypeDroitCode.ADMIN);

	@Transient
	public static final TypeDroit READ = new TypeDroit(TypeDroitCode.READ);

	@Transient
	public static final TypeDroit WRITE = new TypeDroit(TypeDroitCode.WRITE);

	/**
	 * Code du type de droit.
	 */
	@Id
	@Enumerated(EnumType.STRING)
	@Column(name = "TDR_CODE", nullable = false, length = 10, columnDefinition = "varchar")
	private TypeDroitCode code;

	/**
	 * Libellé du type de droit.
	 */
	@Column(name = "TDR_LIBELLE", nullable = false, length = 100, columnDefinition = "varchar")
	private String libelle;

	/**
	 * No arg constructor.
	 */
	public TypeDroit() {
		// No arg constructor
	}

	/**
	 * Enum constructor.
	 * @param code Code dont on veut obtenir l'instance.
	 */
	public TypeDroit(TypeDroitCode code) {
		this.code = code;
		switch(code) {
			case ADMIN:
				this.libelle = "Administration";
				break;
			case READ:
				this.libelle = "Lecture";
				break;
			case WRITE:
				this.libelle = "Ecriture";
				break;
		}
	}

	/**
	 * Getter for code.
	 *
	 * @return value of {@link #code code}.
	 */
	public TypeDroitCode getCode() {
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
}
