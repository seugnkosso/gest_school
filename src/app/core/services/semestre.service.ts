import { Observable } from 'rxjs';
import { RestResponse } from '../models/rest.response';
import { SemestreSelect } from '../models/semestre.liste';

export interface SemestreService {
  findAllSelect(keySearch:string): Observable<RestResponse<SemestreSelect[]>> ;
  findAll(page:number): Observable<RestResponse<SemestreSelect[]>> ;
  create(semestreSelect:SemestreSelect):Observable<RestResponse<SemestreSelect>>;
}
