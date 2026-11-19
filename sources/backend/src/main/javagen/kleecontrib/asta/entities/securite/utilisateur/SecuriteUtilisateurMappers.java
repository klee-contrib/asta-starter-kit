////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite.utilisateur;

import jakarta.annotation.Generated;

import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurCommand;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurItem;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurRead;
import kleecontrib.asta.entities.securite.TypeUtilisateur;

@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class SecuriteUtilisateurMappers {

	private SecuriteUtilisateurMappers() {
		// private constructor to hide implicite public one
	}

	/**
	 * Mappe les champs sources sur l'instance de la classe 'UtilisateurItem' passée en paramètre.
	 * @param utilisateur Instance de 'Utilisateur' source.
	 *
	 * @return L'instance de 'UtilisateurItem' passée en paramètres sur lesquels les champs sources ont été mappés.
	 */
	public static UtilisateurItem createUtilisateurItem(Utilisateur utilisateur) {

		if (utilisateur == null) {
			throw new IllegalArgumentException("utilisateur cannot be null");
		}

		return new UtilisateurItem (
			utilisateur.getId(),
			utilisateur.getNom(),
			utilisateur.getPrenom(),
			utilisateur.getEmail(),
			utilisateur.getTypeUtilisateur() == null ? null : utilisateur.getTypeUtilisateur().getCode()
		);
	}

	/**
	 * Mappe les champs sources sur l'instance de la classe 'UtilisateurRead' passée en paramètre.
	 * @param utilisateur Instance de 'Utilisateur' source.
	 *
	 * @return L'instance de 'UtilisateurRead' passée en paramètres sur lesquels les champs sources ont été mappés.
	 */
	public static UtilisateurRead createUtilisateurRead(Utilisateur utilisateur) {

		if (utilisateur == null) {
			throw new IllegalArgumentException("utilisateur cannot be null");
		}

		return new UtilisateurRead (
			utilisateur.getId(),
			utilisateur.getNom(),
			utilisateur.getPrenom(),
			utilisateur.getEmail(),
			utilisateur.getDateNaissance(),
			utilisateur.getAdresse(),
			utilisateur.getActif(),
			utilisateur.getProfil() == null ? null : utilisateur.getProfil().getId(),
			utilisateur.getTypeUtilisateur() == null ? null : utilisateur.getTypeUtilisateur().getCode(),
			utilisateur.getDateCreation(),
			utilisateur.getDateModification()
		);
	}

	/**
	 * Mappe 'Utilisateur' vers une nouvelle instance de 'UtilisateurCommand'.
	 * @param source Instance de 'UtilisateurCommand' à mapper.
	 *
	 * @return Nouvelle instance de 'UtilisateurCommand' mappée depuis 'utilisateur'.
	 */
	public static Utilisateur toUtilisateur(UtilisateurCommand source) {
		return toUtilisateur(source, new Utilisateur());
	}

	/**
	 * Mappe 'Utilisateur' vers une nouvelle instance ou bien sur l'instance passée en paramètres.
	 * @param source Instance de 'UtilisateurCommand' à mapper.
	 * @param target Instance de 'Utilisateur' sur laquelle mapper.
	 *
	 * @return Nouvelle instance ou bien l'instance passée en paramètres mappée depuis 'utilisateur'.
	 */
	public static Utilisateur toUtilisateur(UtilisateurCommand source, Utilisateur target) {
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
		if (source.getTypeUtilisateurCode() != null) {
			target.setTypeUtilisateur(TypeUtilisateur.getValue(source.getTypeUtilisateurCode()));
		} else {
			target.setTypeUtilisateur(null);
		}

		return target;
	}
}
