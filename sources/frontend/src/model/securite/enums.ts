////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////

export type DroitCode = "CREATE" | "DELETE" | "READ" | "UPDATE";
export interface Droit {
    code: DroitCode;
    libelle: string;
    typeDroit: TypeDroitCode;
}
export const droitList: Droit[] = [
    {
        code: "CREATE",
        libelle: "Création",
        typeDroit: "WRITE"
    },
    {
        code: "DELETE",
        libelle: "Suppression",
        typeDroit: "ADMIN"
    },
    {
        code: "READ",
        libelle: "Lecture",
        typeDroit: "READ"
    },
    {
        code: "UPDATE",
        libelle: "Mise à jour",
        typeDroit: "WRITE"
    },
];
export const droit = {list: droitList, valueKey: "code", labelKey: "libelle"} as const;

export type TypeDroitCode = "ADMIN" | "READ" | "WRITE";
export interface TypeDroit {
    code: TypeDroitCode;
    libelle: string;
}
export const typeDroitList: TypeDroit[] = [
    {
        code: "ADMIN",
        libelle: "Administration"
    },
    {
        code: "WRITE",
        libelle: "Ecriture"
    },
    {
        code: "READ",
        libelle: "Lecture"
    },
];
export const typeDroit = {list: typeDroitList, valueKey: "code", labelKey: "libelle"} as const;

export type TypeUtilisateurCode = "ADMIN" | "CLIENT" | "GEST";
export interface TypeUtilisateur {
    code: TypeUtilisateurCode;
    libelle: string;
}
export const typeUtilisateurList: TypeUtilisateur[] = [
    {
        code: "ADMIN",
        libelle: "Administrateur"
    },
    {
        code: "CLIENT",
        libelle: "Client"
    },
    {
        code: "GEST",
        libelle: "Gestionnaire"
    },
];
export const typeUtilisateur = {list: typeUtilisateurList, valueKey: "code", labelKey: "libelle"} as const;
