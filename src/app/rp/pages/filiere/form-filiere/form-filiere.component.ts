import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import {
  FormBuilder,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

import { Router } from '@angular/router';
import { FiliereServiceImpl } from '../../../../core/services/impl/filiere.service';

@Component({
  selector: 'app-form-filiere',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './form-filiere.component.html',
  styleUrl: './form-filiere.component.css',
})
export class FormFiliereComponent {
  form = this.fb.group({
    id: [],
    libelle: ['', [Validators.required]],
  });
  @Output() onCloseForm: EventEmitter<any> = new EventEmitter();
  constructor(
    private fb: FormBuilder,
    private filiersService: FiliereServiceImpl,
    private router: Router
  ) {}

  closeForm() {
    this.onCloseForm.emit();
  }
  onSubmit() {
    const filiereSelect = this.form.value;
    this.filiersService.create(filiereSelect).subscribe((data) => {
      this.closeForm();
      this.router.navigateByUrl('/',{skipLocationChange:true}).then(() => {
        this.router.navigate(['/RP/filieres'])
      });
    });
  }
}
