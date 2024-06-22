import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { RestResponse } from '../../models/rest.response';
import {
  SessionCourCreat,
  SessionCourExist,
  SessionCourListe,
} from '../../models/sessionCour.liste';
import { SessionCoureService } from '../sessionCour.service';

@Injectable({
  providedIn: 'root',
})
export class SessionCoureServiceImpl implements SessionCoureService {
  apiUrl = `${environment.APIURL}/sessionCours`;
  constructor(private http: HttpClient) {}
  findAllByProf(
    page: number,
    idCour: string,
    idProf: string,
    dateDebut: string = '',
    dateFin: string = ''
  ): Observable<RestResponse<SessionCourListe[]>> {
    return this.http.get<RestResponse<SessionCourListe[]>>(
      `${this.apiUrl}/cour/${idCour}/professeur/${idProf}?page=${page}&dateDebut=${dateDebut}&dateFin=${dateFin}`
    );
  }
  create(
    sessionCourCreate: SessionCourCreat
  ): Observable<RestResponse<SessionCourListe>> {
    return this.http.post<RestResponse<SessionCourListe>>(
      `${this.apiUrl}`,
      sessionCourCreate
    );
  }
  findSessionExistErrors(
    date: string,
    heure: string,
    heureFin: string,
    idCour: string
  ): Observable<RestResponse<SessionCourExist>> {
    return this.http.get<RestResponse<SessionCourExist>>(
      `${this.apiUrl}/heure/${heure}/${heureFin}/${date}/${idCour}`
    );
  }
  findAll(
    page: number = 0,
    idCour: string,
    dateDebut: string,
    dateFin: string
  ): Observable<RestResponse<SessionCourListe[]>> {
    return this.http.get<RestResponse<SessionCourListe[]>>(
      `${this.apiUrl}/cour/${idCour}?page=${page}&dateDebut=${dateDebut}&dateFin=${dateFin}`
    );
  }
}
