import { Observable } from 'rxjs';
import { AnneeScolaireSelect } from '../models/annee-scolaire.liste';
import { RestResponse } from '../models/rest.response';

export interface AnneeScolaireService {
  findAll(page: number): Observable<RestResponse<AnneeScolaireSelect[]>>;
  findAllSelect(libelle: string): Observable<RestResponse<AnneeScolaireSelect[]>>;
  create(anneeScolaireSelect:AnneeScolaireSelect): Observable<RestResponse<AnneeScolaireSelect>>;
}
