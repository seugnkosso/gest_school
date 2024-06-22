import { Observable } from 'rxjs';
import { RestResponse } from '../models/rest.response';
import {
  SessionCourCreat,
  SessionCourExist,
  SessionCourListe,
} from '../models/sessionCour.liste';

export interface SessionCoureService {
  findAll(
    page: number,
    idCour: string,
    dateDebut: string,
    dateFin: string
  ): Observable<RestResponse<SessionCourListe[]>>;
  findAllByProf(
    page: number,
    idCour: string,
    idProf: string,
    dateDebut: string,
    dateFin: string
  ): Observable<RestResponse<SessionCourListe[]>>;
  create(
    sessionCourCreate: SessionCourCreat
  ): Observable<RestResponse<SessionCourListe>>;
  findSessionExistErrors(
    date: string,
    heure: string,
    heureFin: string,
    idCour: string
  ): Observable<RestResponse<SessionCourExist>>;
}
