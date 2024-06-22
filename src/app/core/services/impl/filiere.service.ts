import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { FiliereSelect } from '../../models/filiere.liste';
import { RestResponse } from '../../models/rest.response';
import { FiliereService } from '../filiere.service';

@Injectable({
  providedIn: 'root'
})
export class FiliereServiceImpl implements FiliereService {

  apiUrl = `${environment.APIURL}/filieres`;
  constructor(private http:HttpClient) { }
  create(filiereSelect: FiliereSelect): Observable<RestResponse<FiliereSelect>> {
    return this.http.post<RestResponse<FiliereSelect>>(`${this.apiUrl}`,filiereSelect);
  }
  findAll(page: number = 0): Observable<RestResponse<FiliereSelect[]>> {
    return this.http.get<RestResponse<FiliereSelect[]>>(`${this.apiUrl}?page=${page}`);
  }

  findAllSelect(libelle: string): Observable<RestResponse<FiliereSelect[]>> {
    return this.http.get<RestResponse<FiliereSelect[]>>(`${this.apiUrl}/libelle/${libelle}`);
  }
}
