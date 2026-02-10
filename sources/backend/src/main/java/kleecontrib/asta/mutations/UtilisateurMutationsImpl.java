package kleecontrib.asta.mutations;

import kleecontrib.asta.daos.securite.utilisateur.UtilisateurDAO;
import kleecontrib.asta.daos.securite.profil.ProfilDAO;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurCommand;
import kleecontrib.asta.entities.securite.utilisateur.SecuriteUtilisateurMappers;
import kleecontrib.asta.services.FileStorageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UtilisateurMutationsImpl implements UtilisateurMutations {

    private final UtilisateurDAO utilisateurDAO;
    private final ProfilDAO profilDAO;
    private final FileStorageService fileStorageService;

    public UtilisateurMutationsImpl(UtilisateurDAO utilisateurDAO, ProfilDAO profilDAO, FileStorageService fileStorageService) {
        this.utilisateurDAO = utilisateurDAO;
        this.profilDAO = profilDAO;
        this.fileStorageService = fileStorageService;
    }

    @Override
    public Long addUtilisateur(UtilisateurCommand utilisateur) {
        var utilisateurDb = SecuriteUtilisateurMappers.toUtilisateur(utilisateur);
        
        // Associer le profil
        if (utilisateur.getProfilId() != null) {
            var profil = profilDAO.findById(utilisateur.getProfilId()).orElseThrow();
            utilisateurDb.setProfil(profil);
        }
        
        utilisateurDb = utilisateurDAO.save(utilisateurDb);
        return utilisateurDb.getId();
    }

    @Override
    public void updateUtilisateur(Long utiId, UtilisateurCommand utilisateur) {
        var utilisateurDb = utilisateurDAO.findById(utiId).orElseThrow();
        SecuriteUtilisateurMappers.toUtilisateur(utilisateur, utilisateurDb);
        
        // Associer le profil
        if (utilisateur.getProfilId() != null) {
            var profil = profilDAO.findById(utilisateur.getProfilId()).orElseThrow();
            utilisateurDb.setProfil(profil);
        }
        
        utilisateurDAO.save(utilisateurDb);
    }

    @Override
    public void deleteUtilisateur(Long utiId) {
        utilisateurDAO.deleteById(utiId);
    }

    @Override
    public void addUtilisateurPhoto(Long utiId, MultipartFile photo) {
        var utilisateurDb = utilisateurDAO.findById(utiId).orElseThrow();
        
        if (photo.isEmpty()) {
            throw new IllegalArgumentException("Le fichier photo est vide");
        }
        
        // Sauvegarder le fichier via le service de stockage
        var subDirectory = "utilisateurs/" + utiId;
        var fileName = fileStorageService.storeFile(photo, subDirectory);
        
        // Mettre à jour l'entité
        utilisateurDb.setNomFichierPhoto(fileName);
        utilisateurDAO.save(utilisateurDb);
    }

    @Override
    public void deleteUtilisateurPhoto(Long utiId) {
        var utilisateurDb = utilisateurDAO.findById(utiId).orElseThrow();
        var nomFichier = utilisateurDb.getNomFichierPhoto();
        
        if (nomFichier != null && !nomFichier.isEmpty()) {
            // Supprimer le fichier physique via le service de stockage
            var subDirectory = "utilisateurs/" + utiId;
            fileStorageService.deleteFile(subDirectory, nomFichier);
            
            // Mettre à jour l'entité
            utilisateurDb.setNomFichierPhoto(null);
            utilisateurDAO.save(utilisateurDb);
        }
    }
}
