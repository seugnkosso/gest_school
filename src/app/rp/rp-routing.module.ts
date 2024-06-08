import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AnneeScolaireComponent } from './pages/annee-scolaire/annee-scolaire.component';
import { ClassesComponent } from './pages/classes/classes.component';
import { CoursComponent } from './pages/cours/cours.component';
import { FormCourComponent } from './pages/cours/form.cour/form.cour.component';
import { ModulesComponent } from './pages/modules/modules.component';
import { ProfesseursComponent } from './pages/professeurs/professeurs.component';
import { SallesComponent } from './pages/salles/salles.component';
import { FormSemestreComponent } from './pages/semestre/form.semestre/form.semestre.component';
import { SemestreComponent } from './pages/semestre/semestre.component';
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
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class RPRoutingModule { }
