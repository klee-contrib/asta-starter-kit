////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.profil;

import jakarta.annotation.Generated;

/**
 * Détail d'un profil en liste.
 */
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public interface ProfilItemRead {

	/**
	 * Id technique.
	 */
	Long getId();

	/**
	 * Libellé du profil.
	 */
	String getLibelle();

	/**
	 * Nombre d'utilisateurs affectés au profil.
	 */
	Long getNombreUtilisateurs();

	/**
	 * Id technique.
	 * @param id value to set.
	 */
	void setId(Long id);

	/**
	 * Libellé du profil.
	 * @param libelle value to set.
	 */
	void setLibelle(String libelle);

	/**
	 * Nombre d'utilisateurs affectés au profil.
	 * @param nombreUtilisateurs value to set.
	 */
	void setNombreUtilisateurs(Long nombreUtilisateurs);
}
