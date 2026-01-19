/// /
/// / ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
/// /

package kleecontrib.asta.daos.securite.profil;

import kleecontrib.asta.dtos.securite.profil.ProfilItemRead;
import kleecontrib.asta.entities.securite.profil.Profil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ProfilDAO extends JpaRepository<Profil, Long> {

    @Query("""
            select
                pro.id as id,
                pro.libelle as libelle,
                count(usr) as nombreUtilisateurs
            from Profil pro
                 left join Utilisateur usr on usr.profil.id = pro.id
            group by pro.id, pro.libelle
            """)
    Collection<ProfilItemRead> findAllWithNbUsers();
}
