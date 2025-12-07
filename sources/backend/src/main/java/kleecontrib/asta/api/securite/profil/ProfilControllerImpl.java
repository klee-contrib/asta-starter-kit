package kleecontrib.asta.api.securite.profil;

import kleecontrib.asta.commands.ProfilCommands;
import kleecontrib.asta.dtos.securite.profil.ProfilItem;
import kleecontrib.asta.dtos.securite.profil.ProfilRead;
import kleecontrib.asta.dtos.securite.profil.ProfilWrite;
import kleecontrib.asta.dtos.securite.profil.SecuriteProfilDTOMappers;
import kleecontrib.asta.queries.ProfilQueries;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class ProfilControllerImpl implements ProfilController {
    private final ProfilQueries profilQueries;
    private final ProfilCommands profilCommands;

    public ProfilControllerImpl(ProfilQueries profilQueries, ProfilCommands profilCommands) {
        this.profilQueries = profilQueries;
        this.profilCommands = profilCommands;
    }

    @Override
    public ProfilRead addProfil(ProfilWrite profil) {
        var proId = profilCommands.addProfil(SecuriteProfilDTOMappers.toProfilCommand(profil));
        return profilQueries.getProfil(proId);
    }

    @Override
    public ProfilRead getProfil(Long proId) {
        return profilQueries.getProfil(proId);
    }

    @Override
    public Collection<ProfilItem> getProfils() {
        return profilQueries.getProfils();
    }

    @Override
    public ProfilRead updateProfil(Long proId, ProfilWrite profil) {
        profilCommands.updateProfil(proId, SecuriteProfilDTOMappers.toProfilCommand(profil));
        return profilQueries.getProfil(proId);
    }
}
