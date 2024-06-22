export interface SpecialiteListe {
  id?: number;
  nbrHeure: number;
  isValider: boolean;
  professeur: string;
  semestre: string;
  module: string;
  listeClasse: string;
  etatCour: string;
}

export interface SpecialiteSelect {
  id?: null;
  libelle?: string | null;
}
