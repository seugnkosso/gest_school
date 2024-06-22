import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { RestResponse } from '../../models/rest.response';
import { CreatSalle, SalleListe } from '../../models/salle.liste';
import { SalleService } from '../salle.service';

@Injectable({
  providedIn: 'root',
})
export class SalleServiceImpl implements SalleService {
  private apiUrl = `${environment.APIURL}/Salles`;
  constructor(private http: HttpClient) {}
  findAllBylibelle(libelle:string,heureDebut:string,heureFin:string,date:string): Observable<RestResponse<SalleListe[]>> {
    return this.http.get<RestResponse<SalleListe[]>>(
      `${this.apiUrl}/libelle/${heureDebut}/${heureFin}/${date}?libelle=${libelle}`
    );
  }
  create(creatSalle: CreatSalle): Observable<RestResponse<CreatSalle>> {
    return this.http.post<RestResponse<CreatSalle>>(this.apiUrl, creatSalle)
  }
  findall(
    page: number = 0,
  ): Observable<RestResponse<SalleListe[]>> {
    return this.http.get<RestResponse<SalleListe[]>>(
      `${this.apiUrl}?page=${page}`
    );
  }
}
