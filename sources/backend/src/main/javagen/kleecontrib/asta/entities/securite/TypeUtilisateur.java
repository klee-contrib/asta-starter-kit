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

import kleecontrib.asta.enums.securite.TypeUtilisateurCode;

/**
 * Type d'utilisateur.
 */
@Entity
@Immutable
@Table(name = "TYPE_UTILISATEURS")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class TypeUtilisateur {

	@Transient
	public static final TypeUtilisateur ADMIN = new TypeUtilisateur(TypeUtilisateurCode.ADMIN);

	@Transient
	public static final TypeUtilisateur CLIENT = new TypeUtilisateur(TypeUtilisateurCode.CLIENT);

	@Transient
	public static final TypeUtilisateur GEST = new TypeUtilisateur(TypeUtilisateurCode.GEST);

	/**
	 * Code du type d'utilisateur.
	 */
	@Id
	@Enumerated(EnumType.STRING)
	@Column(name = "TUT_CODE", nullable = false, length = 10, columnDefinition = "varchar")
	private TypeUtilisateurCode code;

	/**
	 * Libellé du type d'utilisateur.
	 */
	@Column(name = "TUT_LIBELLE", nullable = false, length = 100, columnDefinition = "varchar")
	private String libelle;

	/**
	 * No arg constructor.
	 */
	public TypeUtilisateur() {
		// No arg constructor
	}

	/**
	 * Enum constructor.
	 * @param code Code dont on veut obtenir l'instance.
	 */
	public TypeUtilisateur(TypeUtilisateurCode code) {
		this.code = code;
		switch(code) {
			case ADMIN:
				this.libelle = "Administrateur";
				break;
			case CLIENT:
				this.libelle = "Client";
				break;
			case GEST:
				this.libelle = "Gestionnaire";
				break;
		}
	}

	/**
	 * Getter for code.
	 *
	 * @return value of {@link #code code}.
	 */
	public TypeUtilisateurCode getCode() {
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
