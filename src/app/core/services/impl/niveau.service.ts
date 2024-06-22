import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { NiveauSelect } from '../../models/niveau.liste';
import { RestResponse } from '../../models/rest.response';
import { NiveauService } from '../niveau.service';

@Injectable({
  providedIn: 'root'
})
export class NiveauServiceImpl implements NiveauService {

  apiUrl = `${environment.APIURL}/niveaux`;
  constructor(private http:HttpClient) { }
  create(niveauSelect: NiveauSelect): Observable<RestResponse<NiveauSelect>> {
    return this.http.post<RestResponse<NiveauSelect>>(`${this.apiUrl}`,niveauSelect);
  }
  findAll(page: number): Observable<RestResponse<NiveauSelect[]>> {
    return this.http.get<RestResponse<NiveauSelect[]>>(`${this.apiUrl}?page=${page}`);
  }

  findAllSelect(libelle: string): Observable<RestResponse<NiveauSelect[]>> {
    return this.http.get<RestResponse<NiveauSelect[]>>(`${this.apiUrl}/libelle/${libelle}`);
  }
}
