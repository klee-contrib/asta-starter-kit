package kleecontrib.asta.api.securite.profil;

import kleecontrib.asta.dtos.securite.profil.ProfilItem;
import kleecontrib.asta.dtos.securite.profil.ProfilRead;
import kleecontrib.asta.dtos.securite.profil.ProfilWrite;
import kleecontrib.asta.queries.ProfilQueries;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ProfilControllerImpl implements ProfilController {
    private final ProfilQueries profilQueries;

    public ProfilControllerImpl(ProfilQueries profilQueries) {
        this.profilQueries = profilQueries;
    }

    @Override
    public ProfilRead addProfil(ProfilWrite profil) {
        return null;
    }

    @Override
    public ProfilRead getProfil(Long proId) {
        return null;
    }

    @Override
    public Collection<ProfilItem> getProfils() {
        return profilQueries.getProfils();
    }

    @Override
    public ProfilRead updateProfil(Long proId, ProfilWrite profil) {
        return null;
    }
}
