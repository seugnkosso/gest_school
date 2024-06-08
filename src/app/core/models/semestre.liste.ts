export interface SemestreListe {
  id?: number;
  nbrHeure: number;
  isValider: boolean;
  professeur: string;
  semestre: string;
  module: string;
  listeClasse: string;
  etatCour: string;
}

export interface SemestreSelect {
  id?: number;
  libelle: string;
}



