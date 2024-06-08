import { Observable } from 'rxjs';
import { ClasseCreate, ClasseListe, ClasseSelect } from '../models/classe.liste';
import { RestResponse } from '../models/rest.response';

export interface ClasseService {
  findAllSelect(keySearch:string): Observable<RestResponse<ClasseSelect[]>> ;
  findAll(page : number): Observable<RestResponse<ClasseListe[]>> ;
  creat(classeCreate : ClasseCreate): Observable<RestResponse<ClasseCreate>> ;
}
