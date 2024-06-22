import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnneeScolaireComponent } from './pages/annee-scolaire/annee-scolaire.component';
import { ClassesComponent } from './pages/classes/classes.component';
import { CoursComponent } from './pages/cours/cours.component';
import { FormCourComponent } from './pages/cours/form.cour/form.cour.component';
import { FiliereComponent } from './pages/filiere/filiere.component';
import { GradeComponent } from './pages/grade/grade.component';
import { InscriptionComponent } from './pages/inscription/inscription.component';
import { ModulesComponent } from './pages/modules/modules.component';
import { NiveauComponent } from './pages/niveau/niveau.component';
import { ProfesseursComponent } from './pages/professeurs/professeurs.component';
import { SallesComponent } from './pages/salles/salles.component';
import { FormSemestreComponent } from './pages/semestre/form.semestre/form.semestre.component';
import { SemestreComponent } from './pages/semestre/semestre.component';
import { SessionCourComponent } from './pages/session-cour/session-cour.component';
import { SpecialiteComponent } from './pages/specialite/specialite.component';

const routes: Routes = [
  {
    path: 'cours',
    children: [
      {
        path: '',
        component: CoursComponent,
      },
      {
        path: 'form-cour',
        component: FormCourComponent,
      },
    ],
  },
  {
    path: 'semestres',
    children: [
      {
        path: '',
        component: SemestreComponent,
      },
      {
        path: 'form-semestre',
        component: FormSemestreComponent,
      },
    ],
  },
  {
    path: 'professeurs',
    children: [
      {
        path: '',
        component: ProfesseursComponent,
      },
      {
        path: 'form-semestre',
        component: FormSemestreComponent,
      },
    ],
  },
  {
    path: 'anneeScolaires',
    children: [
      {
        path: '',
        component: AnneeScolaireComponent,
      },
    ],
  },
  {
    path: 'salles',
    children: [
      {
        path: '',
        component: SallesComponent,
      },
    ],
  },
  {
    path: 'modules',
    children: [
      {
        path: '',
        component: ModulesComponent,
      },
    ],
  },
  {
    path: 'classes',
    children: [
      {
        path: '',
        component: ClassesComponent,
      },
      {
        path: 'cours/:idCour',
        component: ClassesComponent,
      },
    ],
  },
  {
    path: 'specialites',
    children: [
      {
        path: '',
        component: SpecialiteComponent,
      },
    ],
  },
  {
    path: 'grades',
    children: [
      {
        path: '',
        component: GradeComponent,
      },
    ],
  },
  {
    path: 'filieres',
    children: [
      {
        path: '',
        component: FiliereComponent,
      },
    ],
  },
  {
    path: 'niveaux',
    children: [
      {
        path: '',
        component: NiveauComponent,
      },
    ],
  },
  {
    path: 'sessionCours/cour/:idCour',
    children: [
      {
        path: '',
        component: SessionCourComponent,
      },
    ],
  },
  {
    path: 'Inscriptions',
    children: [
      {
        path: '',
        component: InscriptionComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RPRoutingModule {}
