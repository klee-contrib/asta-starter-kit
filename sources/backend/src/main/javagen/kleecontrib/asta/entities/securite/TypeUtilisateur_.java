////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

package kleecontrib.asta.entities.securite;

import jakarta.annotation.Generated;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

import kleecontrib.asta.enums.securite.TypeUtilisateurCode;

@StaticMetamodel(TypeUtilisateur.class)
@Generated("TopModel : https://github.com/klee-contrib/topmodel")
public class TypeUtilisateur_ {

	public static volatile SingularAttribute<TypeUtilisateur, TypeUtilisateurCode> code;

	public static volatile SingularAttribute<TypeUtilisateur, String> libelle;

	public static final String CODE = "code";

	public static final String LIBELLE = "libelle";
}
