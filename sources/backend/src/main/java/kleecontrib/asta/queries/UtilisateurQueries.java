package kleecontrib.asta.queries;

import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurItem;
import kleecontrib.asta.dtos.securite.utilisateur.UtilisateurRead;
import kleecontrib.asta.enums.securite.TypeUtilisateurCode;
import org.springframework.core.io.Resource;

import java.time.LocalDate;
import java.util.Collection;

public interface UtilisateurQueries {

    /**
     * Charge le détail d'un utilisateur.
     *
     * @param utiId Id de l'utilisateur.
     * @return Le détail de l'utilisateur.
     */
    UtilisateurRead getUtilisateur(Long utiId);

    /**
     * Recherche des utilisateurs.
     *
     * @param nom Nom de l'utilisateur.
     * @param prenom Prénom de l'utilisateur.
     * @param email Email de l'utilisateur.
     * @param dateNaissance Date de naissance de l'utilisateur.
     * @param actif Si l'utilisateur est actif.
     * @param profilId Profil de l'utilisateur.
     * @param typeUtilisateurCode Type d'utilisateur.
     * @return Utilisateurs matchant les critères.
     */
    Collection<UtilisateurItem> searchUtilisateur(
            String nom,
            String prenom,
            String email,
            LocalDate dateNaissance,
            Boolean actif,
            Long profilId,
            TypeUtilisateurCode typeUtilisateurCode
    );

    /**
     * Charge la photo d'un utilisateur (si elle existe).
     *
     * @param utiId Id de l'utilisateur.
     * @return Photo.
     */
    Resource getUtilisateurPhoto(Long utiId);
}
