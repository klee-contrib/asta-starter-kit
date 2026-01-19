/// /
/// / ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
/// /

package kleecontrib.asta.daos.securite.profil;

import kleecontrib.asta.entities.securite.profil.DroitProfil;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface DroitProfilDAO extends JpaRepository<DroitProfil, DroitProfil.DroitProfilId> {
    Collection<DroitProfil> findByProfil_Id(Long proId);

    void deleteByProfil_Id(long proId);
}
