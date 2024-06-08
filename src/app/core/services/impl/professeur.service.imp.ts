import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { ProfesseurCreate, ProfesseurListe, ProfesseurSelect } from '../../models/Professeur.liste';
import { RestResponse } from '../../models/rest.response';
import { ProfesseurService } from '../professeur.service';

@Injectable({
  providedIn: 'root'
})
export class ProfesseurServiceImpl implements ProfesseurService{
  private apiUrl = `${environment.APIURL}/professeurs`;
  constructor(private http: HttpClient) { }

  findAllSelect(keySearch:string): Observable<RestResponse<ProfesseurSelect[]>> {
    return this.http.get<RestResponse<ProfesseurSelect[]>>(`${this.apiUrl}/${keySearch}`);
  }

  findAll(page:number = 0,telephone : string = ''): Observable<RestResponse<ProfesseurListe[]>> {
    return this.http.get<RestResponse<ProfesseurListe[]>>(`${this.apiUrl}?page=${page}&telephone=${telephone}`);
  }
  create(professeurCreate: ProfesseurCreate): Observable<RestResponse<ProfesseurListe>> {
    return this.http.post<RestResponse<ProfesseurListe>>(this.apiUrl, professeurCreate);
  }
}
