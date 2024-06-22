import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import {
  FormBuilder,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { GradeServiceImpl } from '../../../../core/services/impl/grade.service';

@Component({
  selector: 'app-form-grade',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, FormsModule],
  templateUrl: './form-grade.component.html',
  styleUrl: './form-grade.component.css',
})
export class FormGradeComponent {
  form = this.fb.group({
    id: [null, []],
    libelle: [null, [Validators.required]],
  });
  @Output() onCloseForm: EventEmitter<any> = new EventEmitter();
  constructor(private fb: FormBuilder,private gradesService :GradeServiceImpl,private router:Router) {}
  onSubmit() {
    const gradeSelects = this.form.value
    this.gradesService.create(gradeSelects).subscribe(data => {
      this.closeForm()
      this.router.navigateByUrl('/',{skipLocationChange:true}).then(() => {
        this.router.navigateByUrl('/RP/grades')
      })
    })
  }
  closeForm() {
    this.onCloseForm.emit();
  }
}
