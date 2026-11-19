package kleecontrib.asta.queries;

import kleecontrib.asta.daos.securite.utilisateur.UtilisateurDAO;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurItem;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurRead;
import kleecontrib.asta.entities.securite.TypeUtilisateur_;
import kleecontrib.asta.entities.securite.profil.Profil_;
import kleecontrib.asta.entities.securite.utilisateur.SecuriteUtilisateurMappers;
import kleecontrib.asta.entities.securite.utilisateur.Utilisateur;
import kleecontrib.asta.entities.securite.utilisateur.Utilisateur_;
import kleecontrib.asta.enums.securite.TypeUtilisateurCode;
import kleecontrib.asta.services.FileStorageService;
import org.springframework.core.io.Resource;
import org.springframework.data.jpa.domain.Specification;
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
            TypeUtilisateurCode typeUtilisateurCode) {
        // Chaque critère n'est ajouté que s'il est renseigné : aucune valeur par défaut
        // de l'entité n'est appliquée.
        Specification<Utilisateur> spec = Specification.unrestricted();
        spec = spec.and(contient(Utilisateur_.NOM, nom))
                .and(contient(Utilisateur_.PRENOM, prenom))
                .and(contient(Utilisateur_.EMAIL, email))
                .and(egal(Utilisateur_.DATE_NAISSANCE, dateNaissance))
                .and(egal(Utilisateur_.ACTIF, actif));

        if (profilId != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get(Utilisateur_.PROFIL).get(Profil_.ID), profilId));
        }
        if (typeUtilisateurCode != null) {
            spec = spec.and((root, query, cb) -> cb.equal(
                    root.get(Utilisateur_.TYPE_UTILISATEUR).get(TypeUtilisateur_.CODE), typeUtilisateurCode));
        }

        return utilisateurDAO.findAll(spec).stream()
                .map(SecuriteUtilisateurMappers::createUtilisateurItem)
                .toList();
    }

    private static Specification<Utilisateur> contient(String attribut, String valeur) {
        if (valeur == null || valeur.isBlank()) {
            return Specification.unrestricted();
        }
        var motif = "%" + valeur.toLowerCase() + "%";
        return (root, query, cb) -> cb.like(cb.lower(root.get(attribut)), motif);
    }

    private static Specification<Utilisateur> egal(String attribut, Object valeur) {
        if (valeur == null) {
            return Specification.unrestricted();
        }
        return (root, query, cb) -> cb.equal(root.get(attribut), valeur);
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
