import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { RestResponse } from '../../models/rest.response';
import { SemestreSelect } from '../../models/semestre.liste';
import { SemestreService } from '../semestre.service';

@Injectable({
  providedIn: 'root',
})
export class SemestreServiceImpl implements SemestreService {
  apiUrl = `${environment.APIURL}/semestres`;
  constructor(private http: HttpClient) {}

  findAllSelect(keySearch: string): Observable<RestResponse<SemestreSelect[]>> {
    return this.http.get<RestResponse<SemestreSelect[]>>(
      `${this.apiUrl}/${keySearch}`
    );
  }
  findAll(page: number = 0): Observable<RestResponse<SemestreSelect[]>> {
    return this.http.get<RestResponse<SemestreSelect[]>>(`${this.apiUrl}?page=${page}`);
  }

  create(semestreSelect: SemestreSelect): Observable<RestResponse<SemestreSelect>> {
    return this.http.post<RestResponse<SemestreSelect>>(this.apiUrl,semestreSelect);
  }
}
