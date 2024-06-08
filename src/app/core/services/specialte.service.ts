import { Observable } from 'rxjs';
import { RestResponse } from '../models/rest.response';
import { SpecialiteSelect } from '../models/specialte.liste';

export interface SpecialiteService {
  findAllSelect(libelle:string): Observable<RestResponse<SpecialiteSelect[]>> ;
  findAll(page:number): Observable<RestResponse<SpecialiteSelect[]>> ;
}
