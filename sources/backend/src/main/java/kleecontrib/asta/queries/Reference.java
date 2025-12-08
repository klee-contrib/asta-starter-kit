package kleecontrib.asta.queries;

import kleecontrib.asta.entities.securite.Droit;
import kleecontrib.asta.entities.securite.TypeDroit;
import kleecontrib.asta.entities.securite.TypeUtilisateur;

public enum Reference {
    typeUtilisateur(TypeUtilisateur.class),
    typeDroit(TypeDroit.class),
    droit(Droit.class);

    private final Class clazz;

    Reference(Class clazz) {
        this.clazz = clazz;
    }

    Class getClazz() {
        return this.clazz;
    }
}
