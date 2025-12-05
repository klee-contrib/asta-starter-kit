////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import kleecontrib.asta.enums.securite.DroitCode;

@StaticMetamodel(Droit.class)
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class Droit_ {

	public static volatile SingularAttribute<Droit, DroitCode> code;

	public static volatile SingularAttribute<Droit, String> libelle;

	public static volatile SingularAttribute<Droit, TypeDroit> typeDroit;

	public static final String CODE = "code";

	public static final String LIBELLE = "libelle";

	public static final String TYPE_DROIT = "typeDroit";
}
