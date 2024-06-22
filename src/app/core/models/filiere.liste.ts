
export interface FiliereListe {
  id?: number;
  nbrHeure: number;
  isValider: boolean;
  professeur: string;
  semestre: string;
  module: string;
  listeClasse: string;
  etatCour: string;
}

export interface FiliereSelect {
  id?: null;
  libelle?: string | null;
}


