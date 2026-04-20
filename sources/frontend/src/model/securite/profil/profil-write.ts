////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

import {DO_CODE_LISTE, DO_LIBELLE} from "@domains";
import {e, entity, EntityToType} from "@focus4/entities";

import {DroitCode} from "../enums";

export type ProfilWrite = EntityToType<ProfilWriteEntityType>;
export type ProfilWriteEntityType = typeof ProfilWriteEntity;

export const ProfilWriteEntity = entity({
    libelle: e.field(DO_LIBELLE, f => f
        .label("Libellé du profil")
    ),
    droitCodes: e.field(DO_CODE_LISTE, f => f.type<DroitCode[]>()
        .label("Droit")
    )
});
