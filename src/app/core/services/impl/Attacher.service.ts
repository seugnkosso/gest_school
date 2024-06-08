import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { AttacherSelect } from '../../models/attacher.liste';
import { RestResponse } from '../../models/rest.response';
import { AttacherService } from '../attacher.service';

@Injectable({
  providedIn: 'root'
})
export class AttacherServiceImpl implements AttacherService {

  apiUrl = `${environment.APIURL}/attachers`;
  constructor(private http:HttpClient) { }

  findAllSelect(telOrNom: string): Observable<RestResponse<AttacherSelect[]>> {
    return this.http.get<RestResponse<AttacherSelect[]>>(`${this.apiUrl}/telOrNom/${telOrNom}`);
  }
}
