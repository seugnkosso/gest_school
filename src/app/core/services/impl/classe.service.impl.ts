import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { ClasseCreate, ClasseListe, ClasseSelect } from '../../models/classe.liste';
import { RestResponse } from '../../models/rest.response';
import { ClasseService } from '../classe.service';

@Injectable({
  providedIn: 'root'
})
export class ClasseServiceImpl implements ClasseService {
  apiUrl = `${environment.APIURL}/classes`
  constructor(private http:HttpClient) { }
  findByLibelle(libelle: string): Observable<RestResponse<ClasseSelect>> {
    return this.http.get<RestResponse<ClasseSelect>>(`${this.apiUrl}/Onelibelle/${libelle}`)
  }
  creat(classeCreate: ClasseCreate): Observable<RestResponse<ClasseCreate>> {
    return this.http.post<RestResponse<ClasseCreate>>(this.apiUrl, classeCreate)
  }
  findAll(page: number = 0): Observable<RestResponse<ClasseListe[]>> {
      return this.http.get<RestResponse<ClasseListe[]>>(`${this.apiUrl}?page=${page}`)
  }
  findAllSelect(keySearch: string): Observable<RestResponse<ClasseSelect[]>> {
    return this.http.get<RestResponse<ClasseSelect[]>>(`${this.apiUrl}/${keySearch}`)
  }
}
