
export interface NiveauListe {
  id?: number;
  nbrHeure: number;
  isValider: boolean;
  professeur: string;
  semestre: string;
  module: string;
  listeClasse: string;
  etatCour: string;
}

export interface NiveauSelect {
  id?: number;
  libelle?: string;
}


