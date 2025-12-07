package kleecontrib.asta.mutations;

import kleecontrib.asta.daos.securite.profil.DroitProfilDAO;
import kleecontrib.asta.daos.securite.profil.ProfilDAO;
import kleecontrib.asta.dtos.securite.profil.ProfilCommand;
import kleecontrib.asta.entities.securite.Droit;
import kleecontrib.asta.entities.securite.profil.DroitProfil;
import kleecontrib.asta.entities.securite.profil.Profil;
import kleecontrib.asta.entities.securite.profil.SecuriteProfilMappers;
import kleecontrib.asta.enums.securite.DroitCode;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ProfilMutationsImpl implements ProfilMutations {

    private final ProfilDAO profilDAO;
    private final DroitProfilDAO droitProfilDAO;

    public ProfilMutationsImpl(ProfilDAO profilDAO, DroitProfilDAO droitProfilDAO) {
        this.profilDAO = profilDAO;
        this.droitProfilDAO = droitProfilDAO;
    }

    @Override
    public void updateProfil(Long proId, ProfilCommand profil) {
        var profilDb = profilDAO.findById(proId).orElseThrow();
        SecuriteProfilMappers.toProfil(profil, profilDb);
        profilDAO.save(profilDb);
        droitProfilDAO.deleteByProfil_Id(proId);
        saveDroitProfils(profilDb, profil.getDroitCodes());
    }

    @Override
    public Long addProfil(ProfilCommand profil) {
        var profilDb = SecuriteProfilMappers.toProfil(profil);
        profilDb = profilDAO.save(profilDb);
        saveDroitProfils(profilDb, profil.getDroitCodes());
        return profilDb.getId();
    }

    private void saveDroitProfils(final Profil profilDb, final Collection<DroitCode> droitCodes) {
        var droitProfils = droitCodes.stream().map(droitCode -> {
            var droitProfil = new DroitProfil();
            droitProfil.setDroit(new Droit(droitCode));
            droitProfil.setProfil(profilDb);
            return droitProfil;
        }).toList();

        droitProfilDAO.saveAll(droitProfils);
    }
}
