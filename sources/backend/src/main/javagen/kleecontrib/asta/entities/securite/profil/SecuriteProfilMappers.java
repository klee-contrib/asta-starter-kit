////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite.profil;

import jakarta.annotation.Generated;

import kleecontrib.asta.dtos.securite.profil.ProfilCommand;

@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class SecuriteProfilMappers {

	private SecuriteProfilMappers() {
		// private constructor to hide implicite public one
	}

	/**
	 * Mappe 'Profil' vers une nouvelle instance de 'Profil'.
	 * @param source Instance de 'Profil' à mapper.
	 *
	 * @return Nouvelle instance de 'Profil' mappée depuis 'profil'.
	 */
	public static Profil toProfil(Profil source) {
			return toProfil(source, new Profil());
	}

	/**
	 * Mappe 'Profil' vers une nouvelle instance ou bien sur l'instance passée en paramètres.
	 * @param source Instance de 'Profil' à mapper.
	 * @param target Instance de 'Profil' sur laquelle mapper.
	 *
	 * @return Nouvelle instance ou bien l'instance passée en paramètres mappée depuis 'profil'.
	 */
	public static Profil toProfil(Profil source, Profil target) {
		if (source == null) {
			throw new IllegalArgumentException("source cannot be null");
		}

		if (target == null) {
			throw new IllegalArgumentException("target cannot be null");
		}

		target.setLibelle(source.getLibelle());
		return target;
	}

	/**
	 * Mappe 'Profil' vers une nouvelle instance de 'ProfilCommand'.
	 * @param source Instance de 'ProfilCommand' à mapper.
	 *
	 * @return Nouvelle instance de 'ProfilCommand' mappée depuis 'profil'.
	 */
	public static Profil toProfil(ProfilCommand source) {
			return toProfil(source, new Profil());
	}

	/**
	 * Mappe 'Profil' vers une nouvelle instance ou bien sur l'instance passée en paramètres.
	 * @param source Instance de 'ProfilCommand' à mapper.
	 * @param target Instance de 'Profil' sur laquelle mapper.
	 *
	 * @return Nouvelle instance ou bien l'instance passée en paramètres mappée depuis 'profil'.
	 */
	public static Profil toProfil(ProfilCommand source, Profil target) {
		if (source == null) {
			throw new IllegalArgumentException("source cannot be null");
		}

		if (target == null) {
			throw new IllegalArgumentException("target cannot be null");
		}

		target.setLibelle(source.getLibelle());
		return target;
	}
}
