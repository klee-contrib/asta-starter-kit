////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.api.securite.utilisateur;

import java.time.LocalDate;
import java.util.Collection;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurItem;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurRead;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurWrite;
import kleecontrib.asta.enums.securite.TypeUtilisateurCode;

@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public interface UtilisateurController {

	/**
	 * Ajoute un utilisateur.
	 * @param utilisateur Utilisateur à sauvegarder.
	 *
	 * @return Utilisateur sauvegardé.
	 */
	@PostMapping(path = "api/utilisateurs")
	UtilisateurRead addUtilisateur(@RequestBody @Valid UtilisateurWrite utilisateur);

	/**
	 * Ajoute une nouvelle photo pour un utilisateur.
	 * @param utiId Id de l'utilisateur.
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PutMapping(path = "api/utilisateurs/{utiId}/photo", consumes = { "multipart/form-data" })
	void addUtilisateurPhoto(@PathVariable("utiId") Long utiId, @RequestPart(value = "photo", required = true) MultipartFile photo);

	/**
	 * Supprime un utilisateur.
	 * @param utiId Id de l'utilisateur.
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "api/utilisateurs/{utiId}")
	void deleteUtilisateur(@PathVariable("utiId") Long utiId);

	/**
	 * Supprime la photo d'un utilisateur.
	 * @param utiId Id de l'utilisateur.
	 */
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping(path = "api/utilisateurs/{utiId}/photo")
	void deleteUtilisateurPhoto(@PathVariable("utiId") Long utiId);

	/**
	 * Charge le détail d'un utilisateur.
	 * @param utiId Id de l'utilisateur.
	 *
	 * @return Le détail de l'utilisateur.
	 */
	@GetMapping(path = "api/utilisateurs/{utiId}")
	UtilisateurRead getUtilisateur(@PathVariable("utiId") Long utiId);

	/**
	 * Charge la photo d'un utilisateur (si elle existe).
	 * @param utiId Id de l'utilisateur.
	 *
	 * @return Photo.
	 */
	@GetMapping(path = "api/utilisateurs/{utiId}/photo")
	Resource getUtilisateurPhoto(@PathVariable("utiId") Long utiId);

	/**
	 * Recherche des utilisateurs.
	 * @param nom Nom de l'utilisateur.
	 * @param prenom Nom de l'utilisateur.
	 * @param email Email de l'utilisateur.
	 * @param dateNaissance Age de l'utilisateur.
	 * @param actif Si l'utilisateur est actif.
	 * @param profilId Profil de l'utilisateur.
	 * @param typeUtilisateurCode Type d'utilisateur.
	 *
	 * @return Utilisateurs matchant les critères.
	 */
	@GetMapping(path = "api/utilisateurs")
	Collection<UtilisateurItem> searchUtilisateur(@RequestParam(value = "nom", required = false) String nom, @RequestParam(value = "prenom", required = false) String prenom, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "dateNaissance", required = false) LocalDate dateNaissance, @RequestParam(value = "actif", required = false) Boolean actif, @RequestParam(value = "profilId", required = false) Long profilId, @RequestParam(value = "typeUtilisateurCode", required = false) TypeUtilisateurCode typeUtilisateurCode);

	/**
	 * Sauvegarde un utilisateur.
	 * @param utiId Id de l'utilisateur.
	 * @param utilisateur Utilisateur à sauvegarder.
	 *
	 * @return Utilisateur sauvegardé.
	 */
	@PutMapping(path = "api/utilisateurs/{utiId}")
	UtilisateurRead updateUtilisateur(@PathVariable("utiId") Long utiId, @RequestBody @Valid UtilisateurWrite utilisateur);
}
