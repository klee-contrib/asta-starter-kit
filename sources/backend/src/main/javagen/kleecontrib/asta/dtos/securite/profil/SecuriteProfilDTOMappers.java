////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.profil;

import jakarta.annotation.Generated;

@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class SecuriteProfilDTOMappers {

	private SecuriteProfilDTOMappers() {
		// private constructor to hide implicite public one
	}

	/**
	 * Mappe 'ProfilCommand' vers une nouvelle instance de 'ProfilWrite'.
	 * @param source Instance de 'ProfilWrite' à mapper.
	 *
	 * @return Nouvelle instance de 'ProfilWrite' mappée depuis 'profilCommand'.
	 */
	public static ProfilCommand toProfilCommand(ProfilWrite source) {
			return toProfilCommand(source, new ProfilCommand());
	}

	/**
	 * Mappe 'ProfilCommand' vers une nouvelle instance ou bien sur l'instance passée en paramètres.
	 * @param source Instance de 'ProfilWrite' à mapper.
	 * @param target Instance de 'ProfilCommand' sur laquelle mapper.
	 *
	 * @return Nouvelle instance ou bien l'instance passée en paramètres mappée depuis 'profilCommand'.
	 */
	public static ProfilCommand toProfilCommand(ProfilWrite source, ProfilCommand target) {
		if (source == null) {
			throw new IllegalArgumentException("source cannot be null");
		}

		if (target == null) {
			throw new IllegalArgumentException("target cannot be null");
		}

		target.setLibelle(source.getLibelle());
		target.setDroitCodes(source.getDroitCodes());
		return target;
	}
}
