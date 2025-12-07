package kleecontrib.asta.queries;

import kleecontrib.asta.dtos.securite.profil.ProfilItem;
import kleecontrib.asta.dtos.securite.profil.ProfilRead;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

public interface ProfilQueries {

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


}
