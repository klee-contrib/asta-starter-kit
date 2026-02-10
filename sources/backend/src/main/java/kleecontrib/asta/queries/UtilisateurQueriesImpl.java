package kleecontrib.asta.queries;

import kleecontrib.asta.daos.securite.utilisateur.UtilisateurDAO;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurItem;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurRead;
import kleecontrib.asta.entities.securite.TypeUtilisateur;
import kleecontrib.asta.entities.securite.profil.Profil;
import kleecontrib.asta.entities.securite.utilisateur.SecuriteUtilisateurMappers;
import kleecontrib.asta.entities.securite.utilisateur.Utilisateur;
import kleecontrib.asta.enums.securite.TypeUtilisateurCode;
import kleecontrib.asta.services.FileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;

@Service
public class UtilisateurQueriesImpl implements UtilisateurQueries {
    private final UtilisateurDAO utilisateurDAO;
    private final FileStorageService fileStorageService;

    public UtilisateurQueriesImpl(UtilisateurDAO utilisateurDAO, FileStorageService fileStorageService) {
        this.utilisateurDAO = utilisateurDAO;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public UtilisateurRead getUtilisateur(Long utiId) {
        var utilisateurDb = utilisateurDAO.findById(utiId).orElseThrow();
        return SecuriteUtilisateurMappers.createUtilisateurRead(utilisateurDb);
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
        var utilisateurProbe = new Utilisateur();
        if (nom != null) {
            utilisateurProbe.setNom(nom);
        }
        if (prenom != null) {
            utilisateurProbe.setPrenom(prenom);
        }
        if (email != null) {
            utilisateurProbe.setEmail(email);
        }
        if (dateNaissance != null) {
            utilisateurProbe.setDateNaissance(dateNaissance);
        }
        utilisateurProbe.setActif(actif);

        if (profilId != null) {
            var profil = new Profil();
            profil.setId(profilId);
            utilisateurProbe.setProfil(profil);
        }

        if (typeUtilisateurCode != null) {
            utilisateurProbe.setTypeUtilisateur(new TypeUtilisateur(typeUtilisateurCode));
        }
        utilisateurProbe.setDateCreation(null);
        utilisateurProbe.setDateModification(null);
        var matcher = ExampleMatcher.matching()
                .withIgnoreNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING)
                .withIgnoreCase();

        var example = Example.of(utilisateurProbe, matcher);

        return utilisateurDAO.findAll(example).stream()
                .map(SecuriteUtilisateurMappers::createUtilisateurItem)
                .toList();
    }

    @Override
    public Resource getUtilisateurPhoto(Long utiId) {
        var utilisateurDb = utilisateurDAO.findById(utiId).orElseThrow();
        var nomFichier = utilisateurDb.getNomFichierPhoto();

        if (nomFichier == null || nomFichier.isEmpty()) {
            throw new IllegalStateException("L'utilisateur n'a pas de photo");
        }

        // Charger le fichier via le service de stockage
        var subDirectory = "utilisateurs/" + utiId;
        return fileStorageService.loadFileAsResource(subDirectory, nomFichier);
    }
}
