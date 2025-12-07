package kleecontrib.asta.commands;

import jakarta.transaction.Transactional;
import kleecontrib.asta.dtos.securite.profil.ProfilCommand;
import kleecontrib.asta.mutations.ProfilMutations;
import org.springframework.stereotype.Service;

@Service
public class ProfilCommandsImpl implements ProfilCommands {
    private final ProfilMutations profilMutations;

    public ProfilCommandsImpl(ProfilMutations profilMutations) {
        this.profilMutations = profilMutations;
    }

    @Override
    @Transactional
    public void updateProfil(Long proId, ProfilCommand profil) {
        profilMutations.updateProfil(proId, profil);
    }

    @Override
    @Transactional
    public Long addProfil(ProfilCommand profil) {
        return profilMutations.addProfil(profil);
    }
}
