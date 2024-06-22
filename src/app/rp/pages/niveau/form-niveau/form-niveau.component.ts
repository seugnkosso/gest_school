import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import {
  FormBuilder,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { NiveauServiceImpl } from '../../../../core/services/impl/niveau.service';


@Component({
  selector: 'app-form-niveau',
  standalone: true,
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './form-niveau.component.html',
  styleUrl: './form-niveau.component.css',
})
export class FormNiveauComponent {
  form = this.fb.group({
    id: [],
    libelle: [null, [Validators.required]],
  });
  @Output() onCloseForm : EventEmitter<any> = new EventEmitter();
  constructor(private fb: FormBuilder,private niveauService : NiveauServiceImpl,private router:Router) {}
  closeForm() {
    this.onCloseForm.emit()
  }
  onSubmit() {
    const niveauSelect = this.form.value
    this.niveauService.create(niveauSelect).subscribe(data=>{
      this.closeForm()
      this.router.navigateByUrl('/',{skipLocationChange:true}).then(()=>{
        this.router.navigate(['/RP/niveaux'])
      })
    })
  }
}
