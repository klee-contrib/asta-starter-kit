////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite.profil;

import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Profil.class)
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class Profil_ {

	public static volatile SingularAttribute<Profil, Long> id;

	public static volatile SingularAttribute<Profil, String> libelle;

	public static volatile SingularAttribute<Profil, LocalDateTime> dateCreation;

	public static volatile SingularAttribute<Profil, LocalDateTime> dateModification;

	public static final String ID = "id";

	public static final String LIBELLE = "libelle";

	public static final String DATE_CREATION = "dateCreation";

	public static final String DATE_MODIFICATION = "dateModification";
}
