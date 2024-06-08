import { Observable } from 'rxjs';
import { GradeSelect } from '../models/grade.liste';
import { RestResponse } from '../models/rest.response';

export interface GradeService {
  findAllSelect(libelle:string): Observable<RestResponse<GradeSelect[]>> ;
}
