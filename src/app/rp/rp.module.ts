import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';

import { HeaderComponent } from './components/header/header.component';
import { SidebarComponent } from './components/sidebar/sidebar.component';
import { LayoutComponentRp } from './layout/layout.component';
import { RPRoutingModule } from './rp-routing.module';

@NgModule({
  declarations: [SidebarComponent, HeaderComponent, LayoutComponentRp],
  imports: [CommonModule, RPRoutingModule],
})
export class RPModule {}
