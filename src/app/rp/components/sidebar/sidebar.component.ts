import { Component } from '@angular/core';

@Component({
  selector: 'app-sidebar',
  standalone:false,
  templateUrl: './sidebar.component.html',
  styleUrl: './sidebar.component.css'
})
export class SidebarComponent {

  buttonClicked = true
  configClicked = true
closeSidebar() {
    this.buttonClicked = true
}
openSidebar() {
    this.buttonClicked = false
}

togleConfig() {
  if(this.configClicked == false)
    {
      this.configClicked = true
    }else{
      this.configClicked = false
    }
}
}
