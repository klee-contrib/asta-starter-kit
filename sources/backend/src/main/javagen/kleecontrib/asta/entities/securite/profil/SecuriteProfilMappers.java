////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite.profil;

import java.util.Collection;

import jakarta.annotation.Generated;

import kleecontrib.asta.dtos.securite.profil.ProfilCommand;
import kleecontrib.asta.dtos.securite.profil.ProfilRead;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurItem;
import kleecontrib.asta.enums.securite.DroitCode;

@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class SecuriteProfilMappers {

	private SecuriteProfilMappers() {
		// private constructor to hide implicite public one
	}

	/**
	 * Crée une nouvelle instance de la classe 'ProfilRead' en mappant les champs sources.
	 * @param profil Instance de 'Profil' source.
	 * @param droitCodes Code du droit.
	 * @param utilisateurs Utilisateurs ayant ce profil.
	 *
	 * @return Une nouvelle instance de 'ProfilRead' sur laquelle les champs sources ont été mappés.
	 */
	public static ProfilRead createProfilRead(Profil profil, Collection<DroitCode> droitCodes, Collection<UtilisateurItem> utilisateurs) {
		return mapProfilRead(profil, droitCodes, utilisateurs, new ProfilRead());
	}

	/**
	 * Mappe les champs sources sur l'instance de la classe 'ProfilRead' passée en paramètre.
	 * @param profil Instance de 'Profil' source.
	 * @param droitCodes Code du droit.
	 * @param utilisateurs Utilisateurs ayant ce profil.
	 * @param target Instance de 'ProfilRead' cible.
	 *
	 * @return L'instance de 'ProfilRead' passée en paramètres sur lesquels les champs sources ont été mappés.
	 */
	public static ProfilRead mapProfilRead(Profil profil, Collection<DroitCode> droitCodes, Collection<UtilisateurItem> utilisateurs, ProfilRead target) {
		if (target == null) {
			throw new IllegalArgumentException("target cannot be null");
		}

		if (profil == null) {
			throw new IllegalArgumentException("profil cannot be null");
		}

		if (droitCodes == null) {
			throw new IllegalArgumentException("droitCodes cannot be null");
		}

		if (utilisateurs == null) {
			throw new IllegalArgumentException("utilisateurs cannot be null");
		}

		target.setId(profil.getId());
		target.setLibelle(profil.getLibelle());
		target.setDateCreation(profil.getDateCreation());
		target.setDateModification(profil.getDateModification());
		target.setDroitCodes(droitCodes);
		target.setUtilisateurs(utilisateurs);
		return target;
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
