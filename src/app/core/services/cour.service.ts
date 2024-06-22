import { Observable } from 'rxjs';
import { CourListe, CreatCour } from '../models/cour.liste';
import { RestResponse } from '../models/rest.response';

export interface CourService {
  findall(
    page: number,
    telephone: string
  ): Observable<RestResponse<CourListe[]>>;
  findallByProfId(
    page: number,
    idprof: string,
    telephone: string
  ): Observable<RestResponse<CourListe[]>>;
  create(creatCour: CreatCour): Observable<RestResponse<CreatCour>>;
}
