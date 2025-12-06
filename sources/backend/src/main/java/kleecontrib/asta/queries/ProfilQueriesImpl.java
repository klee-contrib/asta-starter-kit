package kleecontrib.asta.queries;

import kleecontrib.asta.daos.securite.profil.ProfilDAO;
import kleecontrib.asta.dtos.securite.profil.ProfilItem;
import kleecontrib.asta.dtos.securite.profil.ProfilRead;
import kleecontrib.asta.dtos.securite.profil.ProfilWrite;
import kleecontrib.asta.dtos.securite.profil.SecuriteProfilDTOMappers;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProfilQueriesImpl implements ProfilQueries {
    private final ProfilDAO profilDAO;

    public ProfilQueriesImpl(ProfilDAO profilDAO) {
        this.profilDAO = profilDAO;
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
        return profilDAO
                .findAllWithNbUsers()
                .stream()
                .map(SecuriteProfilDTOMappers::createProfilItem)
                .toList();
    }

    @Override
    public ProfilRead updateProfil(Long proId, ProfilWrite profil) {
        return null;
    }
}
