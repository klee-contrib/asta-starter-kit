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
	 * Mappe les champs sources sur l'instance de la classe 'ProfilItem' passée en paramètre.
	 * @param profilItemRead Instance de 'ProfilItemRead' source.
	 *
	 * @return L'instance de 'ProfilItem' passée en paramètres sur lesquels les champs sources ont été mappés.
	 */
	public static ProfilItem createProfilItem(ProfilItemRead profilItemRead) {

		if (profilItemRead == null) {
			throw new IllegalArgumentException("profilItemRead cannot be null");
		}

		return new ProfilItem (
			profilItemRead.getId(),
			profilItemRead.getLibelle(),
			profilItemRead.getNombreUtilisateurs()
		);
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
