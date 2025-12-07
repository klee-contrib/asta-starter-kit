package kleecontrib.asta.queries;

import kleecontrib.asta.daos.securite.profil.DroitProfilDAO;
import kleecontrib.asta.daos.securite.profil.ProfilDAO;
import kleecontrib.asta.daos.securite.utilisateur.UtilisateurDAO;
import kleecontrib.asta.dtos.securite.profil.ProfilItem;
import kleecontrib.asta.dtos.securite.profil.ProfilRead;
import kleecontrib.asta.dtos.securite.profil.SecuriteProfilDTOMappers;
import kleecontrib.asta.entities.securite.Droit;
import kleecontrib.asta.entities.securite.profil.DroitProfil;
import kleecontrib.asta.entities.securite.profil.SecuriteProfilMappers;
import kleecontrib.asta.entities.securite.utilisateur.SecuriteUtilisateurMappers;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProfilQueriesImpl implements ProfilQueries {
    private final ProfilDAO profilDAO;
    private final DroitProfilDAO droitProfilDAO;
    private final UtilisateurDAO utilisateurDAO;

    public ProfilQueriesImpl(ProfilDAO profilDAO, DroitProfilDAO droitProfilDAO, UtilisateurDAO utilisateurDAO) {
        this.profilDAO = profilDAO;
        this.droitProfilDAO = droitProfilDAO;
        this.utilisateurDAO = utilisateurDAO;
    }

    @Override
    public ProfilRead getProfil(Long proId) {
        var profilDb = profilDAO.findById(proId).orElseThrow();
        var droitProfils = droitProfilDAO.findByProfil_Id(proId);
        var utilisateurs = utilisateurDAO.findByProfil_Id(proId);
        return SecuriteProfilMappers.createProfilRead(
                profilDb,
                droitProfils.stream().map(DroitProfil::getDroit).map(Droit::getCode).toList(),
                utilisateurs.stream().map(SecuriteUtilisateurMappers::createUtilisateurItem).toList()
        );
    }

    @Override
    public Collection<ProfilItem> getProfils() {
        return profilDAO
                .findAllWithNbUsers()
                .stream()
                .map(SecuriteProfilDTOMappers::createProfilItem)
                .toList();
    }
}
