import { Observable } from 'rxjs';
import { RestResponse } from '../models/rest.response';
import { CreatSalle, SalleListe } from '../models/salle.liste';

export interface SalleService {
  findall(page:number): Observable<RestResponse<SalleListe[]>> ;
  create(creatSalle:CreatSalle): Observable<RestResponse<CreatSalle>> ;
  findAllBylibelle(libelle:string,heureDebut:string,heureFin:string,date:string): Observable<RestResponse<SalleListe[]>> ;
}
