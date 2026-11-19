/// /
/// / ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
/// /

package kleecontrib.asta.daos.securite.utilisateur;

import kleecontrib.asta.entities.securite.utilisateur.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Collection;

public interface UtilisateurDAO extends JpaRepository<Utilisateur, Long>, JpaSpecificationExecutor<Utilisateur> {
    Collection<Utilisateur> findByProfil_Id(Long proId);
}
