import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { GradeSelect } from '../../models/grade.liste';
import { RestResponse } from '../../models/rest.response';
import { GradeService } from '../grade.service';

@Injectable({
  providedIn: 'root'
})
export class GradeServiceImpl implements GradeService {

  apiUrl = `${environment.APIURL}/grades`;
  constructor(private http:HttpClient) { }
  create(gradeSelect: GradeSelect): Observable<RestResponse<GradeSelect>> {
    return this.http.post<RestResponse<GradeSelect>>(`${this.apiUrl}`,gradeSelect);
  }
  findAll(page: number): Observable<RestResponse<GradeSelect[]>> {
    return this.http.get<RestResponse<GradeSelect[]>>(`${this.apiUrl}?page=${page}`);
  }

  findAllSelect(libelle: string): Observable<RestResponse<GradeSelect[]>> {
    return this.http.get<RestResponse<GradeSelect[]>>(`${this.apiUrl}/libelle/${libelle}`);
  }
}
