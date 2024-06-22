import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { HeaderComponent } from './components/header/header.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { LayoutProfComponent } from './layout-prof/layout-prof.component';
import { ProfesseurRoutingModule } from './professeur-routing.module';

@NgModule({
  declarations: [SidebarComponent, HeaderComponent, LayoutProfComponent],
  imports: [CommonModule, ProfesseurRoutingModule],
})
export class ProfesseurModule {}
