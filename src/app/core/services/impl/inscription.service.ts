import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import {
  CreatInscription,
  InscriptionListe,
} from '../../models/inscription.liste';
import { RestResponse } from '../../models/rest.response';
import { InscriptionService } from '../inscription.service.';

@Injectable({
  providedIn: 'root',
})
export class InscriptionServiceImpl implements InscriptionService {
  apiUrl = `${environment.APIURL}/Inscriptions`;
  constructor(private http: HttpClient) {}
  findall(
    page: number = 0,
    matricule: string = ''
  ): Observable<RestResponse<InscriptionListe[]>> {
    return this.http.get<RestResponse<InscriptionListe[]>>(
      `${this.apiUrl}?page=${page}&matricule=${matricule}`
    );
  }
  create(
    createInscription: CreatInscription
  ): Observable<RestResponse<InscriptionListe>> {
    return this.http.post<RestResponse<InscriptionListe>>(
      `${this.apiUrl}`,
      createInscription
    );
  }
}
