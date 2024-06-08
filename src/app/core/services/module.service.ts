import { Observable } from 'rxjs';
import { ModuleSelect } from '../models/Module.liste';
import { RestResponse } from '../models/rest.response';

export interface ModuleService {
  findAllSelect(keySearch:string): Observable<RestResponse<ModuleSelect[]>> ;
  findAll(page:number): Observable<RestResponse<ModuleSelect[]>> ;
  create(moduleSelect:ModuleSelect): Observable<RestResponse<ModuleSelect>> ;
}
