import { ModuleSelect } from "./Module.liste";
import { ProfesseurSelect } from "./Professeur.liste";
import { ClasseSelect } from "./classe.liste";
import { SemestreSelect } from "./semestre.liste";

export interface CourListe {
  id?: number;
  nbrHeure: number;
  isValider: boolean;
  professeur: string;
  semestre: string;
  module: string;
  listeClasse: string;
  etatCour: string;
}

export interface CreatCour {
  nbrHeure: number;
  professeur: ProfesseurSelect;
  semestre:SemestreSelect ;
  module: ModuleSelect;
  listeClasse: ClasseSelect[];
}


