import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { EtudiantList } from '../../models/etudiant.liste';
import { RestResponse } from '../../models/rest.response';
import { EtudiantService } from '../etudiant.service';

@Injectable({
  providedIn: 'root',
})
export class EtudiantServiceImpl implements EtudiantService {
  apiUrl = `${environment.APIURL}/Etudiants`;
  constructor(private http: HttpClient) {}

  findById(id: number): Observable<RestResponse<EtudiantList>> {
    return this.http.get<RestResponse<EtudiantList>>(`${this.apiUrl}/${id}`);
  }
}
