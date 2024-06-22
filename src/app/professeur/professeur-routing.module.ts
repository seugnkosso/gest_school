import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CourProfComponent } from './pages/cour-prof/cour-prof.component';
import { SessionCourProfComponent } from './pages/session-cour-prof/session-cour-prof.component';

const routes: Routes = [
  {
    path: 'cours/:idProf',
    children: [
      {
        path: '',
        component: CourProfComponent,
      },
    ],
  },
  {
    path: 'sessionCours/cour/:idCour/:idProf',
    children: [
      {
        path: '',
        component: SessionCourProfComponent,
      },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProfesseurRoutingModule {}
