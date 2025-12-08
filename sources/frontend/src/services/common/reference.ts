////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////


import { HttpClient, HttpContext, HttpHeaders, HttpParams } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { Observable } from "rxjs";
@Injectable({
    providedIn: 'root'
})
export class ReferenceService {

    private readonly http = inject(HttpClient);

    /**
     * @description Récupère une liste de référence
     * @param referenceName Nom de la liste de référence
     * @returns Liste de référence
     */
    getReference(referenceName: "typeUtilisateur" | "typeDroit" | "droit", options: {headers?: HttpHeaders | {[header: string]: string | string[]}; context?: HttpContext; params?: HttpParams | {[param: string]: string | number | boolean | ReadonlyArray<string | number | boolean>}; withCredentials?: boolean; reportProgress?: boolean; transferCache?: {includeHeaders?: string[]} | boolean} = {}): Observable<Object[]> {
        return this.http.get<Object[]>(`/api/reference/${referenceName}`, {observe: 'body', ...options});
    }
}
