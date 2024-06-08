import { Observable } from 'rxjs';
import { FiliereSelect } from '../models/filiere.liste';
import { RestResponse } from '../models/rest.response';

export interface FiliereService {
  findAllSelect(libelle:string): Observable<RestResponse<FiliereSelect[]>> ;
}
