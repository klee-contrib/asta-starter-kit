////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

import {DO_ENTIER, DO_ID, DO_LIBELLE} from "@domains";
import {e, entity, EntityToType} from "@focus4/entities";

export type ProfilItem = EntityToType<ProfilItemEntityType>;
export type ProfilItemEntityType = typeof ProfilItemEntity;

export const ProfilItemEntity = entity({
    id: e.field(DO_ID, f => f.optional()
        .label("Id technique du profil")
    ),
    libelle: e.field(DO_LIBELLE, f => f
        .label("Libellé du profil")
    ),
    nombreUtilisateurs: e.field(DO_ENTIER, f => f
        .label("Nombre d'utilisateurs affectés")
    )
});
