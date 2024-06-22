import { Injectable } from '@angular/core';
import { Role } from '../../models/role.enum';
import { AuthentificateService } from './authentificate.service';

@Injectable({
  providedIn: 'root',
})
export class IdentifyService {
  role?: Role;
  constructor(private authservice: AuthentificateService) {}
  identified(tab: String[]) {
    if (tab.indexOf('RP') != -1) {
      return Role.RP;
    }
    if (tab.indexOf('Professeur') != -1) {
      return Role.Professeur;
    }
    return 'null';
  }
  getRoleConnecter() {
    return localStorage.getItem('role');
  }

  RpIsIdentified() {
    return (
      this.authservice.authentification() == true &&
      this.getRoleConnecter() == Role.RP
    );
  }

  ProfesseurIsIdentified() {
    return (
      this.authservice.authentification() == true &&
      this.getRoleConnecter() == Role.Professeur
    );
  }
}
