////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

import {DO_BOOLEEN, DO_LIBELLE} from "@domains";
import {e, entity, EntityToType} from "@focus4/entities";

export type AuthProperties = EntityToType<AuthPropertiesEntityType>;
export type AuthPropertiesEntityType = typeof AuthPropertiesEntity;

export const AuthPropertiesEntity = entity({
    authority: e.field(DO_LIBELLE, f => f.optional()
        .label("Authority")
    ),
    clientId: e.field(DO_LIBELLE, f => f.optional()
        .label("ClientId")
    ),
    requireHttps: e.field(DO_BOOLEEN, f => f.optional()
        .label("requireHttps")
    )
});
