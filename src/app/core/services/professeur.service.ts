import { Observable } from 'rxjs';
import {
  ProfesseurCreate,
  ProfesseurListe,
  ProfesseurSelect,
} from '../models/Professeur.liste';
import { RestResponse } from '../models/rest.response';

export interface ProfesseurService {
  findAllSelect(
    keySearch: string
  ): Observable<RestResponse<ProfesseurSelect[]>>;
  findAll(
    page: number,
    telephone: string
  ): Observable<RestResponse<ProfesseurListe[]>>;
  create(
    professeurCreate: ProfesseurCreate
  ): Observable<RestResponse<ProfesseurListe>>;
}
