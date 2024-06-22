import { Observable } from 'rxjs';
import {
  CreatInscription,
  InscriptionListe,
} from '../models/inscription.liste';
import { RestResponse } from '../models/rest.response';

export interface InscriptionService {
  findall(
    page: number,
    matricule: string
  ): Observable<RestResponse<InscriptionListe[]>>;
  create(
    createinscription: CreatInscription
  ): Observable<RestResponse<InscriptionListe>>;
}
