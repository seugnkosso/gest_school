import { inject } from '@angular/core';
import { Routes } from '@angular/router';
import { PageNotFoundComponent } from './core/component/page.not.found/page.not.found.component';
import { IdentifyService } from './core/services/auth/identify.service';
import { LoginComponent } from './public/pages/login/login.component';
import { LayoutComponent } from './rp/layout/layout.component';

export const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'RP',
    component: LayoutComponent,
    loadChildren: () => import('./rp/rp.module').then((mod) => mod.RPModule),
    canMatch:[()=>inject(IdentifyService).RpIsIdentified()],
  },
  {
    path: '',
    redirectTo: '/RP/cours',
    pathMatch: 'full',

  },
  {
    path: '**',
    component: PageNotFoundComponent, //pageNotFound Component
  },
];
