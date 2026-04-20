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
	public static final TypeDroit ADMIN = new TypeDroit(TypeDroitCode.ADMIN, "Administration");

	@Transient
	public static final TypeDroit READ = new TypeDroit(TypeDroitCode.READ, "Lecture");

	@Transient
	public static final TypeDroit WRITE = new TypeDroit(TypeDroitCode.WRITE, "Ecriture");

	/**
	 * Liste de toutes les valeurs de l'énumération TypeDroit.
	 */
	public static final List<TypeDroit> VALUES = List.of(ADMIN, WRITE, READ);

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
	 * All args constructor for 'TypeDroit'.
	 * @param code Code du type de droit.
	 * @param libelle Libellé du type de droit.
	 */
	private TypeDroit(TypeDroitCode code, String libelle) {
		this.code = code;
		this.libelle = libelle;
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

	/**
	 * Retourne la valeur de l'énumération pour la clé spécifiée.
	 * @param code La clé de l'énumération pour laquelle obtenir la valeur.
	 *
	 * @return La valeur de l'énumération correspondant à la clé 'Code'.
	 */
	public static TypeDroit getValue(TypeDroitCode code) {
		return switch (code) {
			case ADMIN -> ADMIN;
			case READ -> READ;
			case WRITE -> WRITE;
		};
	}
}
