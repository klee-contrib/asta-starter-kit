////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite;

import javax.annotation.Generated;
import javax.persistence.metamodel.StaticMetamodel;

import jakarta.persistence.metamodel.SingularAttribute;

import kleecontrib.asta.enums.securite.TypeDroitCode;

@StaticMetamodel(TypeDroit.class)
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class TypeDroit_ {

	public static volatile SingularAttribute<TypeDroit, TypeDroitCode> code;

	public static volatile SingularAttribute<TypeDroit, String> libelle;

	public static final String CODE = "code";

	public static final String LIBELLE = "libelle";
}
