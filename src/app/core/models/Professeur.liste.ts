
export interface ProfesseurListe {
    id?: number;
    nomComplet?:string;
    telephone?: string;
    email?: string;
    specialite?: string;
    grade?: string;
}

export interface ProfesseurSelect {
  id?: number;
  nomComplet?: string;
}

export interface  ProfesseurCreate {
  nomComplet?: string | null;
  telephone?: string | null;
  email?: string | null;
  username?: string | null;
  searchSpecilite?: string | null;
  specialite?: null;
  searchGrade?: string | null;
  grades?: null;
}



