import { Observable } from 'rxjs';
import { AttacherSelect } from '../models/attacher.liste';
import { RestResponse } from '../models/rest.response';

export interface AttacherService {
  findAllSelect(telOrNom:string): Observable<RestResponse<AttacherSelect[]>> ;
}
