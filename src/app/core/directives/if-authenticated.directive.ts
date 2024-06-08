import { NgIf } from '@angular/common';
import { Directive, OnInit, inject } from '@angular/core';
import { AuthentificateService } from '../services/auth/authentificate.service';

@Directive({
  selector: '[IfAuthenticated]',
  standalone: true,
  hostDirectives:[{
    directive:NgIf
  }]
})
export class IfAuthenticatedDirective implements OnInit {

   private   authServ:AuthentificateService=inject(AuthentificateService)
   private ngIfDirective=inject(NgIf)

   ngOnInit(): void {
      this.ngIfDirective.ngIf=this.authServ.isAuthentificated
  }


}
