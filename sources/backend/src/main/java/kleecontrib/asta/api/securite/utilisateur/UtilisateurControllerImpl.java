package kleecontrib.asta.api.securite.utilisateur;

import kleecontrib.asta.commands.UtilisateurCommands;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurItem;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurRead;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurWrite;
import kleecontrib.asta.dtos.securite.utilisateur.SecuriteUtilisateurDTOMappers;
import kleecontrib.asta.enums.securite.TypeUtilisateurCode;
import kleecontrib.asta.queries.UtilisateurQueries;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.util.Collection;

@RestController
public class UtilisateurControllerImpl implements UtilisateurController {
    private final UtilisateurQueries utilisateurQueries;
    private final UtilisateurCommands utilisateurCommands;

    public UtilisateurControllerImpl(UtilisateurQueries utilisateurQueries, UtilisateurCommands utilisateurCommands) {
        this.utilisateurQueries = utilisateurQueries;
        this.utilisateurCommands = utilisateurCommands;
    }

    @Override
    public UtilisateurRead addUtilisateur(UtilisateurWrite utilisateur) {
        var utiId = utilisateurCommands.addUtilisateur(SecuriteUtilisateurDTOMappers.toUtilisateurCommand(utilisateur));
        return utilisateurQueries.getUtilisateur(utiId);
    }

    @Override
    public void addUtilisateurPhoto(Long utiId, MultipartFile photo) {
        utilisateurCommands.addUtilisateurPhoto(utiId, photo);
    }

    @Override
    public void deleteUtilisateur(Long utiId) {
        utilisateurCommands.deleteUtilisateur(utiId);
    }

    @Override
    public void deleteUtilisateurPhoto(Long utiId) {
        utilisateurCommands.deleteUtilisateurPhoto(utiId);
    }

    @Override
    public UtilisateurRead getUtilisateur(Long utiId) {
        return utilisateurQueries.getUtilisateur(utiId);
    }

    @Override
    public Resource getUtilisateurPhoto(Long utiId) {
        return utilisateurQueries.getUtilisateurPhoto(utiId);
    }

    @Override
    public Collection<UtilisateurItem> searchUtilisateur(
            String nom,
            String prenom,
            String email,
            LocalDate dateNaissance,
            Boolean actif,
            Long profilId,
            TypeUtilisateurCode typeUtilisateurCode
    ) {
        return utilisateurQueries.searchUtilisateur(nom, prenom, email, dateNaissance, actif, profilId, typeUtilisateurCode);
    }

    @Override
    public UtilisateurRead updateUtilisateur(Long utiId, UtilisateurWrite utilisateur) {
        utilisateurCommands.updateUtilisateur(utiId, SecuriteUtilisateurDTOMappers.toUtilisateurCommand(utilisateur));
        return utilisateurQueries.getUtilisateur(utiId);
    }
}
