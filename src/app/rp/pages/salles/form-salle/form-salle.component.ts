import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormBuilder, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { SalleServiceImpl } from '../../../../core/services/impl/salle.service.impl ';

@Component({
  selector: 'app-form-salle',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './form-salle.component.html',
  styleUrl: './form-salle.component.css',
})
export class FormSalleComponent {

  constructor(private fb: FormBuilder,private salleService:SalleServiceImpl,private router:Router) {}
  @Output() onCloseForm: EventEmitter<any> = new EventEmitter();
  form = this.fb.group({
    libelle: ['', [Validators.required]],
    numero: [null, [Validators.required]],
    nbrPlace: [null, [Validators.required]],
  });

  close() {
    this.onCloseForm.emit();
  }

  onSubmit() {
    const salleCreate = this.form.value
    this.salleService.create(salleCreate).subscribe(data=>{
      this.close()
      this.router.navigateByUrl('/',{skipLocationChange:true}).then(()=>{
        this.router.navigate(['/RP/salles'])
      })
    })
    }
}
