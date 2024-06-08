import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import {
  FormBuilder,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { NgSelectModule } from '@ng-select/ng-select';
import { GradeSelect } from '../../../../core/models/grade.liste';
import { SpecialiteSelect } from '../../../../core/models/specialte.liste';
import { GradeServiceImpl } from '../../../../core/services/impl/grade.service';
import { ProfesseurServiceImpl } from '../../../../core/services/impl/professeur.service.imp';
import { SpecialiteServiceImpl } from '../../../../core/services/impl/specialite.service';

@Component({
  selector: 'app-form-professeur',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NgSelectModule, FormsModule],
  templateUrl: './form.professeur.component.html',
  styleUrl: './form.professeur.component.css',
})
export class FormProfesseurComponent {
  constructor(
    private fb: FormBuilder,
    private specialiteService: SpecialiteServiceImpl,
    private gradeService: GradeServiceImpl,
    private profService : ProfesseurServiceImpl,
    private router:Router
  ) {}
  @Output() onCloseForm: EventEmitter<any> = new EventEmitter();
  specialiteSelects: SpecialiteSelect[] = [];
  gradeSelects: GradeSelect[] = [];
  form = this.fb.group({
    nomComplet: ['', [Validators.required]],
    telephone: ['', [Validators.required, Validators.minLength(9)]],
    email: ['', [Validators.required]],
    username: ['', [Validators.required]],
    searchSpecilite: ['', []],
    specialite: [null, [Validators.required]],
    searchGrade: ['', []],
    grades: [[], [Validators.required]],
  });

  closeForm() {
    this.onCloseForm.emit();
  }

  searchSpecialite() {
    const specialite = this.form.controls['searchSpecilite'].value;
    if (specialite != null && specialite.length >= 4) {
      this.specialiteService.findAllSelect(specialite).subscribe((data) => {
        this.specialiteSelects = data.results;
      });
    }
  }

  searchGrade() {
    const grade = this.form.controls['searchGrade'].value;
    if (grade != null && grade.length >= 4) {
      this.gradeService.findAllSelect(grade).subscribe((data) => {
        this.gradeSelects = data.results;
      });
    }
  }

  onSubmit() {
    const professeurCreate = this.form.value;
    this.profService.create(professeurCreate).subscribe((data) => {
      this.closeForm()
      this.router.navigateByUrl('/',{skipLocationChange:true}).then(()=>{
        this.router.navigate([`/RP/professeurs`])
      })
    })
  }
}
