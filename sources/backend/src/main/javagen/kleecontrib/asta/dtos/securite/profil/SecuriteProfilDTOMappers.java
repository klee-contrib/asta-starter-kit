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
	 * Crée une nouvelle instance de la classe 'ProfilItem' en mappant les champs sources.
	 * @param profilItemRead Instance de 'ProfilItemRead' source.
	 *
	 * @return Une nouvelle instance de 'ProfilItem' sur laquelle les champs sources ont été mappés.
	 */
	public static ProfilItem createProfilItem(ProfilItemRead profilItemRead) {
		return mapProfilItem(profilItemRead, new ProfilItem());
	}

	/**
	 * Mappe les champs sources sur l'instance de la classe 'ProfilItem' passée en paramètre.
	 * @param profilItemRead Instance de 'ProfilItemRead' source.
	 * @param target Instance de 'ProfilItem' cible.
	 *
	 * @return L'instance de 'ProfilItem' passée en paramètres sur lesquels les champs sources ont été mappés.
	 */
	public static ProfilItem mapProfilItem(ProfilItemRead profilItemRead, ProfilItem target) {
		if (target == null) {
			throw new IllegalArgumentException("target cannot be null");
		}

		if (profilItemRead == null) {
			throw new IllegalArgumentException("profilItemRead cannot be null");
		}

		target.setId(profilItemRead.getId());
		target.setLibelle(profilItemRead.getLibelle());
		target.setNombreUtilisateurs(profilItemRead.getNombreUtilisateurs());
		return target;
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
