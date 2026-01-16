////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.profil;

import javax.annotation.Generated;

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
	 * Hydrate values of instance.
	 * @param id value to set.
	 * @param libelle value to set.
	 * @param nombreUtilisateurs value to set.
	 */
	void hydrate(Long id, String libelle, Long nombreUtilisateurs);
}
