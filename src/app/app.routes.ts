import { inject } from '@angular/core';
import { Routes } from '@angular/router';
import { IdentifyService } from './core/services/auth/identify.service';
import { LayoutProfComponent } from './professeur/layout-prof/layout-prof.component';
import { LoginComponent } from './public/pages/login/login.component';
import { LayoutComponentRp } from './rp/layout/layout.component';

export const routes: Routes = [
  {
    path: 'RP',
    component: LayoutComponentRp,
    loadChildren: () => import('./rp/rp.module').then((mod) => mod.RPModule),
    canMatch: [() => inject(IdentifyService).RpIsIdentified()],
  },
  {
    path: 'professeur',
    component: LayoutProfComponent,
    loadChildren: () =>
      import('./professeur/professeur.module').then(
        (mod) => mod.ProfesseurModule
      ),
    canMatch: [() => inject(IdentifyService).ProfesseurIsIdentified()],
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: '',
    redirectTo: '/login',
    pathMatch: 'full',
  },
  {
    path: '**',
    redirectTo: '/login',
    pathMatch: 'full', //pageNotFound Component
  },
];
