import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { CourListe, CreatCour } from '../../models/cour.liste';
import { RestResponse } from '../../models/rest.response';
import { CourService } from '../cour.service';

@Injectable({
  providedIn: 'root',
})
export class CourServiceImpl implements CourService {
  private apiUrl = `${environment.APIURL}/cours`;
  constructor(private http: HttpClient) {}
  create(creatCour: CreatCour): Observable<RestResponse<CreatCour>> {
    return this.http.post<RestResponse<CreatCour>>(
      `${this.apiUrl}`,
      creatCour
    );
  }
  findall(
    page: number = 0,
    telephone: string = ''
  ): Observable<RestResponse<CourListe[]>> {
    return this.http.get<RestResponse<CourListe[]>>(
      `${this.apiUrl}?page=${page}&telephone=${telephone}`
    );
  }
}
