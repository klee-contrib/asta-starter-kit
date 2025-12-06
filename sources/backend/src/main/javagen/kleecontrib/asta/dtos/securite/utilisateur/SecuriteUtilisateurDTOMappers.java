////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.dtos.securite.utilisateur;

import jakarta.annotation.Generated;

@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class SecuriteUtilisateurDTOMappers {

	private SecuriteUtilisateurDTOMappers() {
		// private constructor to hide implicite public one
	}

	/**
	 * Mappe 'UtilisateurCommand' vers une nouvelle instance de 'UtilisateurWrite'.
	 * @param source Instance de 'UtilisateurWrite' à mapper.
	 *
	 * @return Nouvelle instance de 'UtilisateurWrite' mappée depuis 'utilisateurCommand'.
	 */
	public static UtilisateurCommand toUtilisateurCommand(UtilisateurWrite source) {
			return toUtilisateurCommand(source, new UtilisateurCommand());
	}

	/**
	 * Mappe 'UtilisateurCommand' vers une nouvelle instance ou bien sur l'instance passée en paramètres.
	 * @param source Instance de 'UtilisateurWrite' à mapper.
	 * @param target Instance de 'UtilisateurCommand' sur laquelle mapper.
	 *
	 * @return Nouvelle instance ou bien l'instance passée en paramètres mappée depuis 'utilisateurCommand'.
	 */
	public static UtilisateurCommand toUtilisateurCommand(UtilisateurWrite source, UtilisateurCommand target) {
		if (source == null) {
			throw new IllegalArgumentException("source cannot be null");
		}

		if (target == null) {
			throw new IllegalArgumentException("target cannot be null");
		}

		target.setNom(source.getNom());
		target.setPrenom(source.getPrenom());
		target.setEmail(source.getEmail());
		target.setDateNaissance(source.getDateNaissance());
		target.setAdresse(source.getAdresse());
		target.setActif(source.getActif());
		target.setProfilId(source.getProfilId());
		target.setTypeUtilisateurCode(source.getTypeUtilisateurCode());
		return target;
	}
}
