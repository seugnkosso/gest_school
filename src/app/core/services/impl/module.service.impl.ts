import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../../../../environments/environment.development';
import { ModuleSelect } from '../../models/Module.liste';
import { RestResponse } from '../../models/rest.response';
import { ModuleService } from '../module.service';

@Injectable({
  providedIn: 'root'
})
export class ModuleServiceImpl implements ModuleService {
  apiUr = `${environment.APIURL}/modules`
  constructor(private http:HttpClient) { }
  create(moduleSelect: ModuleSelect): Observable<RestResponse<ModuleSelect>> {
    return this.http.post<RestResponse<ModuleSelect>>(this.apiUr, moduleSelect)
  }
  findAll(page: number = 0): Observable<RestResponse<ModuleSelect[]>> {
    return this.http.get<RestResponse<ModuleSelect[]>>(`${this.apiUr}?page=${page}`)
  }
  findAllSelect(keySearch: string): Observable<RestResponse<ModuleSelect[]>> {
    return this.http.get<RestResponse<ModuleSelect[]>>(`${this.apiUr}/${keySearch}`);
  }
}
