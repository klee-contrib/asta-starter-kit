////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

import {DO_BOOLEEN, DO_CODE, DO_DATE, DO_EMAIL, DO_ID, DO_LIBELLE} from "@domains";
import {e, entity, EntityToType} from "@focus4/entities";

import {TypeUtilisateurCode} from "../references";

export type UtilisateurWrite = EntityToType<UtilisateurWriteEntityType>;
export type UtilisateurWriteEntityType = typeof UtilisateurWriteEntity;

export const UtilisateurWriteEntity = entity({
    nom: e.field(DO_LIBELLE, f => f
        .label("Nom")
    ),
    prenom: e.field(DO_LIBELLE, f => f
        .label("Prénom")
    ),
    email: e.field(DO_EMAIL, f => f
        .label("Adresse email")
    ),
    dateNaissance: e.field(DO_DATE, f => f.optional()
        .label("Date de naissance")
    ),
    adresse: e.field(DO_LIBELLE, f => f.optional()
        .label("Adresse")
    ),
    actif: e.field(DO_BOOLEEN, f => f.defaultValue(true)
        .label("Actif")
    ),
    profilId: e.field(DO_ID, f => f
        .label("Profil")
    ),
    typeUtilisateurCode: e.field(DO_CODE, f => f.type<TypeUtilisateurCode>().defaultValue("GEST")
        .label("Type d'utilisateur")
    )
});
