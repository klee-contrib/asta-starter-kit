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
	public static final TypeUtilisateur ADMIN = new TypeUtilisateur(TypeUtilisateurCode.ADMIN, "Administrateur");

	@Transient
	public static final TypeUtilisateur CLIENT = new TypeUtilisateur(TypeUtilisateurCode.CLIENT, "Client");

	@Transient
	public static final TypeUtilisateur GESTIONNAIRE = new TypeUtilisateur(TypeUtilisateurCode.GEST, "Gestionnaire");

	/**
	 * Liste de toutes les valeurs de l'énumération TypeUtilisateur.
	 */
	public static final List<TypeUtilisateur> VALUES = List.of(ADMIN, CLIENT, GESTIONNAIRE);

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
	 * All args constructor for 'TypeUtilisateur'.
	 * @param code Code du type d'utilisateur.
	 * @param libelle Libellé du type d'utilisateur.
	 */
	private TypeUtilisateur(TypeUtilisateurCode code, String libelle) {
		this.code = code;
		this.libelle = libelle;
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

	/**
	 * Retourne la valeur de l'énumération pour la clé spécifiée.
	 * @param code La clé de l'énumération pour laquelle obtenir la valeur.
	 *
	 * @return La valeur de l'énumération correspondant à la clé 'Code'.
	 */
	public static TypeUtilisateur getValue(TypeUtilisateurCode code) {
		return switch (code) {
			case ADMIN -> ADMIN;
			case CLIENT -> CLIENT;
			case GEST -> GESTIONNAIRE;
		};
	}
}
