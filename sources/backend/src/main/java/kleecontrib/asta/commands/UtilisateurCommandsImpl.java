package kleecontrib.asta.commands;

import jakarta.transaction.Transactional;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurCommand;
import kleecontrib.asta.mutations.UtilisateurMutations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UtilisateurCommandsImpl implements UtilisateurCommands {
    private final UtilisateurMutations utilisateurMutations;

    public UtilisateurCommandsImpl(UtilisateurMutations utilisateurMutations) {
        this.utilisateurMutations = utilisateurMutations;
    }

    @Override
    @Transactional
    public Long addUtilisateur(UtilisateurCommand utilisateur) {
        return utilisateurMutations.addUtilisateur(utilisateur);
    }

    @Override
    @Transactional
    public void updateUtilisateur(Long utiId, UtilisateurCommand utilisateur) {
        utilisateurMutations.updateUtilisateur(utiId, utilisateur);
    }

    @Override
    @Transactional
    public void deleteUtilisateur(Long utiId) {
        utilisateurMutations.deleteUtilisateur(utiId);
    }

    @Override
    @Transactional
    public void addUtilisateurPhoto(Long utiId, MultipartFile photo) {
        utilisateurMutations.addUtilisateurPhoto(utiId, photo);
    }

    @Override
    @Transactional
    public void deleteUtilisateurPhoto(Long utiId) {
        utilisateurMutations.deleteUtilisateurPhoto(utiId);
    }
}
