export interface ClasseListe {
  id?: number;
  libelle?: String;
  attacher?: String;
  filiere?: String;
  niveau?: String;
  anneeScolaire?: String;
}

export interface ClasseSelect {
  id?: number;
  libelle?: string;
}
export interface ClasseCreate {
  libelle?: string | null;
  searchAttacher?: string | null;
  attacher?: null;
  searchFiliere?: string | null;
  filiere?: null;
  searchNiveau?: string | null;
  niveau?: null;
  searchAnnee?: string | null;
  anneeScolaire?: null;
}
