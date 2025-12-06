package kleecontrib.asta.api.securite.profil;

import kleecontrib.asta.dtos.securite.profil.ProfilItem;
import kleecontrib.asta.dtos.securite.profil.ProfilRead;
import kleecontrib.asta.dtos.securite.profil.ProfilWrite;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
public class ProfilControllerImpl implements ProfilController {
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
        return List.of();
    }

    @Override
    public ProfilRead updateProfil(Long proId, ProfilWrite profil) {
        return null;
    }
}
