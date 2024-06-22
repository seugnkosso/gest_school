import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { RestResponse } from '../../models/rest.response';
import { SpecialiteSelect } from '../../models/specialte.liste';
import { SpecialiteService } from '../specialte.service';

@Injectable({
  providedIn: 'root'
})
export class SpecialiteServiceImpl implements SpecialiteService {
  apiUrl = `${environment.APIURL}/specialites`;
  constructor(private http: HttpClient) { }
  create(specialiteSelect: SpecialiteSelect): Observable<RestResponse<SpecialiteSelect>> {
    return this.http.post<RestResponse<SpecialiteSelect>>(this.apiUrl, specialiteSelect)
  }
  findAll(page: number = 0): Observable<RestResponse<SpecialiteSelect[]>> {
    return this.http.get<RestResponse<SpecialiteSelect[]>>(`${this.apiUrl}?page=${page}`);
  }
  findAllSelect(libelle: string): Observable<RestResponse<SpecialiteSelect[]>> {
    return this.http.get<RestResponse<SpecialiteSelect[]>>(`${this.apiUrl}/libelle/${libelle}`);
  }
}
