package kleecontrib.asta.queries;

import jakarta.validation.Valid;
import kleecontrib.asta.dtos.securite.profil.ProfilItem;
import kleecontrib.asta.dtos.securite.profil.ProfilRead;
import kleecontrib.asta.dtos.securite.profil.ProfilWrite;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;

public interface ProfilQueries {

    /**
     * Ajoute un Profil.
     *
     * @param profil Profil à sauvegarder.
     * @return Profil sauvegardé.
     */
    @PostMapping(path = "api/profils")
    ProfilRead addProfil(@RequestBody @Valid ProfilWrite profil);

    /**
     * Charge le détail d'un Profil.
     *
     * @param proId Id technique.
     * @return Le détail de l'Profil.
     */
    ProfilRead getProfil(@PathVariable("proId") Long proId);

    /**
     * Liste tous les Profils.
     *
     * @return Profils matchant les critères.
     */
    Collection<ProfilItem> getProfils();

    /**
     * Sauvegarde un Profil.
     *
     * @param proId  Id technique.
     * @param profil Profil à sauvegarder.
     * @return Profil sauvegardé.
     */
    ProfilRead updateProfil(@PathVariable("proId") Long proId, @RequestBody @Valid ProfilWrite profil);

}
