////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.api.securite.profil;

import java.util.Collection;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.annotation.Generated;
import jakarta.validation.Valid;

import kleecontrib.asta.dtos.securite.profil.ProfilItem;
import kleecontrib.asta.dtos.securite.profil.ProfilRead;
import kleecontrib.asta.dtos.securite.profil.ProfilWrite;

@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public interface ProfilController {

	/**
	 * Ajoute un Profil.
	 * @param profil Profil à sauvegarder.
	 *
	 * @return Profil sauvegardé.
	 */
	@PostMapping(path = "api/profils")
	ProfilRead addProfil(@RequestBody @Valid ProfilWrite profil);

	/**
	 * Charge le détail d'un Profil.
	 * @param proId Id technique.
	 *
	 * @return Le détail de l'Profil.
	 */
	@GetMapping(path = "api/profils/{proId}")
	ProfilRead getProfil(@PathVariable("proId") Long proId);

	/**
	 * Liste tous les Profils.
	 *
	 * @return Profils matchant les critères.
	 */
	@GetMapping(path = "api/profils")
	Collection<ProfilItem> getProfils();

	/**
	 * Sauvegarde un Profil.
	 * @param proId Id technique.
	 * @param profil Profil à sauvegarder.
	 *
	 * @return Profil sauvegardé.
	 */
	@PutMapping(path = "api/profils/{proId}")
	ProfilRead updateProfil(@PathVariable("proId") Long proId, @RequestBody @Valid ProfilWrite profil);
}
