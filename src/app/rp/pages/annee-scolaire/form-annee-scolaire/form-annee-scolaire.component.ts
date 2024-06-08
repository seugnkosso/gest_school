import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import {
  FormBuilder,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { AnneeScolaireServiceImpl } from '../../../../core/services/impl/annee-scolaire.service';

@Component({
  selector: 'app-form-annee-scolaire',
  standalone: true,
  imports: [FormsModule, CommonModule, ReactiveFormsModule],
  templateUrl: './form-annee-scolaire.component.html',
  styleUrl: './form-annee-scolaire.component.css',
})
export class FormAnneeScolaireComponent {

  @Output() onCloseForm: EventEmitter<any> = new EventEmitter();
  constructor(private fb: FormBuilder,private anneeService : AnneeScolaireServiceImpl,private router:Router) {}
  form = this.fb.group({
    id:[null,[]],
    libelle: ['', [Validators.required]],
  });

  closeForm() {
    this.onCloseForm.emit();
  }

  onSubmit() {
    const anneeScolaireSelect = this.form.value
    this.anneeService.create(anneeScolaireSelect).subscribe(data=>{
      this.closeForm()
      this.router.navigateByUrl('/',{skipLocationChange:true}).then(()=>{
        this.router.navigate([`/RP/anneeScolaires`])
      })
    })
  }
}
