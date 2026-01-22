////
//// ATTENTION CE FICHIER EST GENERE AUTOMATIQUEMENT !
////


import { HttpClient, HttpContext, HttpHeaders, HttpParams } from "@angular/common/http";
import { inject, Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { AuthProperties } from "../../../model/securite/auth/auth-properties";
@Injectable({
    providedIn: 'root'
})
export class AuthService {

    private readonly http = inject(HttpClient);

    /**
     * @description Récupère l'ensemble des propriétés nécessaires à la connexion
     * @returns Informations relatives à la connexion
     */
    authenticationProperties(options: {headers?: HttpHeaders | {[header: string]: string | string[]}; context?: HttpContext; params?: HttpParams | {[param: string]: string | number | boolean | ReadonlyArray<string | number | boolean>}; withCredentials?: boolean; reportProgress?: boolean; transferCache?: {includeHeaders?: string[]} | boolean} = {}): Observable<AuthProperties> {
        return this.http.get<AuthProperties>(`/api/auth/authentication-properties`, {observe: 'body', ...options});
    }
}
