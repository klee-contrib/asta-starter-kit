package kleecontrib.asta.mutations;

import jakarta.validation.Valid;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurCommand;
import org.springframework.web.multipart.MultipartFile;

public interface UtilisateurMutations {
    /**
     * Ajoute un utilisateur.
     *
     * @param utilisateur Utilisateur à sauvegarder.
     * @return Id de l'utilisateur sauvegardé.
     */
    Long addUtilisateur(@Valid UtilisateurCommand utilisateur);

    /**
     * Sauvegarde un utilisateur.
     *
     * @param utiId Id de l'utilisateur.
     * @param utilisateur Utilisateur à sauvegarder.
     */
    void updateUtilisateur(Long utiId, @Valid UtilisateurCommand utilisateur);

    /**
     * Supprime un utilisateur.
     *
     * @param utiId Id de l'utilisateur.
     */
    void deleteUtilisateur(Long utiId);

    /**
     * Ajoute une nouvelle photo pour un utilisateur.
     *
     * @param utiId Id de l'utilisateur.
     * @param photo Photo à ajouter.
     */
    void addUtilisateurPhoto(Long utiId, MultipartFile photo);

    /**
     * Supprime la photo d'un utilisateur.
     *
     * @param utiId Id de l'utilisateur.
     */
    void deleteUtilisateurPhoto(Long utiId);
}
