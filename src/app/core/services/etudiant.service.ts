import { Observable } from 'rxjs';
import { EtudiantList } from '../models/etudiant.liste';
import { RestResponse } from '../models/rest.response';

export interface EtudiantService {
  findById(id: number): Observable<RestResponse<EtudiantList>>;
}
