import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { AnneeScolaireSelect } from '../../models/annee-scolaire.liste';
import { RestResponse } from '../../models/rest.response';
import { AnneeScolaireService } from '../annee-scolaire.service';

@Injectable({
  providedIn: 'root'
})
export class AnneeScolaireServiceImpl implements AnneeScolaireService {

  apiUrl = `${environment.APIURL}/anneeScolaires`
  findAll(page: number): Observable<RestResponse<AnneeScolaireSelect[]>> {
    return this.http.get<RestResponse<AnneeScolaireSelect[]>>(`${this.apiUrl}?page=${page}`);
  }
  constructor(private http:HttpClient) { }
  findAllSelect(libelle: string): Observable<RestResponse<AnneeScolaireSelect[]>> {
    return this.http.get<RestResponse<AnneeScolaireSelect[]>>(`${this.apiUrl}/libelle/${libelle}`);
  }
  create(anneeScolaireSelect:AnneeScolaireSelect): Observable<RestResponse<AnneeScolaireSelect>> {
    return this.http.post<RestResponse<AnneeScolaireSelect>>(`${this.apiUrl}`,anneeScolaireSelect);
  }
}
