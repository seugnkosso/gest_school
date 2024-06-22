export interface InscriptionListe {
  id?: number;
  date?: string;
  etudiant?: string;
  idEtudiant?: number;
  anneeScolaire?: string;
}

export interface CreatInscription {
  etudiant?: Partial<{
    telephone: string | null;
    matricule: string | null;
    nomComplet: string | null;
  }>;
  searchAnnee?: string | null;
  anneeScolaire?: null;
  searchClasse?: string | null;
  classe?: null;
}
