/// /
/// / ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
/// /

package kleecontrib.asta.daos.securite.utilisateur;

import kleecontrib.asta.entities.securite.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Long> {
    Collection<Utilisateur> findByProfil_Id(Long proId);
}
