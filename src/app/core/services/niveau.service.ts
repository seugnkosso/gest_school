
import { Observable } from 'rxjs';
import { NiveauSelect } from '../models/niveau.liste';
import { RestResponse } from '../models/rest.response';

export interface NiveauService {
  findAllSelect(libelle:string): Observable<RestResponse<NiveauSelect[]>> ;
}
