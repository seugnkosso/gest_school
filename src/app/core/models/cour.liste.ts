
export interface CourListe {
  id?: number;
  nbrHeure?: number;
  isValider?: boolean;
  professeur?: string;
  semestre?: string;
  module?: string;
  listeClasse?: string;
  etatCour?: string;
}

export interface CreatCour {
  nbrHeure?: null;
  prof?: string | null;
  professeur?: null;
  mod?: string | null;
  module?: null;
  sem?: string | null;
  semestre?: null;
  Clas?: string | null;
  classes?: null;
}


