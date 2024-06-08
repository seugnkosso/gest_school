import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { TokenResponse } from '../../../core/models/login.model';
import { RestResponse } from '../../../core/models/rest.response';
import { AuthentificateService } from '../../../core/services/auth/authentificate.service';
import { IdentifyService } from '../../../core/services/auth/identify.service';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css',
})
export class LoginComponent {
  form: FormGroup;
  constructor(
    private fb: FormBuilder,
    private authService: AuthentificateService,
    private identifyS: IdentifyService,
    private router: Router
  ) {
    this.form = this.fb.group({
      username: '',
      password: '',
    });
  }

  ngOnInit(): void {

  }

  onSubmit() {
    let data = this.form.getRawValue();
    this.authService
      .login(data)
      .subscribe((res: RestResponse<TokenResponse>) => {
        if (res.status == 200) {
          localStorage.setItem('connecter', 'true');
          localStorage.setItem('token', res.results.token);
          localStorage.setItem('role',this.identifyS.identified(res.results.roles))
          this.router.navigateByUrl('/RP/cours');
        } else {
          console.log('Error');
        }
        //
      });
  }
}
