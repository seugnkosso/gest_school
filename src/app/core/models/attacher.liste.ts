
export interface AttacherListe {
  id?: number;
  nbrHeure: number;
  isValider: boolean;
  professeur: string;
  semestre: string;
  module: string;
  listeClasse: string;
  etatCour: string;
}

export interface AttacherSelect {
  id?: number;
  nomComplet: string;
}


