export interface SessionCourListe {
  id?: null;
  date?: null;
  heureDebutFin?: null;
  salle?: string;
  etat?: null;
}

export interface SessionCourCreat {
  date?: null;
  heureDebut?: null;
  heureFin?: null;
  searchSalle?: string | null;
  salle?: string | null;
  cour?: string | null;
  etat?: null;
}

export interface SessionCourExist {
  SessionProfExist?: boolean;
  SessionClasseExist?: boolean;
}
