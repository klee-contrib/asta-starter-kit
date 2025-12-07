////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

import {DO_CODE_LISTE, DO_DATE_HEURE, DO_ID, DO_LIBELLE} from "@domains";
import {e, entity, EntityToType} from "@focus4/entities";

import {DroitCode} from "../references";
import {UtilisateurItemEntity} from "../utilisateur/utilisateur-item";

export type ProfilRead = EntityToType<ProfilReadEntityType>;
export type ProfilReadEntityType = typeof ProfilReadEntity;

export const ProfilReadEntity = entity({
    id: e.field(DO_ID, f => f.optional()
        .label("Id technique du profil")
    ),
    libelle: e.field(DO_LIBELLE, f => f
        .label("Libellé du profil")
    ),
    dateCreation: e.field(DO_DATE_HEURE, f => f
        .label("Date de création")
    ),
    dateModification: e.field(DO_DATE_HEURE, f => f.optional()
        .label("Date de modification")
    ),
    droitCodes: e.field(DO_CODE_LISTE, f => f.type<DroitCode[]>()
        .label("Droit")
    ),
    utilisateurs: e.list(UtilisateurItemEntity, f => f
        .label("Utilisateurs")
    )
});
