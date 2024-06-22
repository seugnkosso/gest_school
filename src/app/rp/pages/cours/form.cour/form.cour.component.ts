import { CommonModule } from '@angular/common';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {
  FormBuilder,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { NgSelectModule } from '@ng-select/ng-select';
import { ModuleSelect } from '../../../../core/models/Module.liste';
import { ProfesseurSelect } from '../../../../core/models/Professeur.liste';
import { ClasseSelect } from '../../../../core/models/classe.liste';
import { SemestreSelect } from '../../../../core/models/semestre.liste';
import { ClasseServiceImpl } from '../../../../core/services/impl/classe.service.impl';
import { CourServiceImpl } from '../../../../core/services/impl/cour.service.impl';
import { ModuleServiceImpl } from '../../../../core/services/impl/module.service.impl';
import { ProfesseurServiceImpl } from '../../../../core/services/impl/professeur.service.imp';
import { SemestreServiceImpl } from '../../../../core/services/impl/semestre.service.impl';


@Component({
  selector: 'app-form-cour',
  templateUrl: './form.cour.component.html',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, NgSelectModule, FormsModule],
  styleUrl: './form.cour.component.css',
})
export class FormCourComponent implements OnInit {
  professeurs?: ProfesseurSelect[];
  modules?: ModuleSelect[];
  semestres?: SemestreSelect[];
  classesSelect?: ClasseSelect[];

  form = this.fb.group({
    nbrHeure: [null, Validators.required, Validators.min(4)],
    prof: [''],
    professeur: [null, Validators.required],
    mod: [''],
    module: [null, Validators.required],
    sem: [''],
    semestre: [null, Validators.required],
    Clas: [''],
    classes: [null, Validators.required],
  });
  @Output() onCloseForm : EventEmitter<any> = new EventEmitter()
  constructor(
    private fb: FormBuilder,
    private professeurService: ProfesseurServiceImpl,
    private moduleService: ModuleServiceImpl,
    private semestreService: SemestreServiceImpl,
    private classeService: ClasseServiceImpl,
    private courService: CourServiceImpl,
    private router: Router
  ) {}
  ngOnInit(): void {}
  closeForm() {
    this.onCloseForm.emit()
  }
  onProfSearch() {
    const prof = this.form.controls['prof'].value;
    if (prof != null) {
      if (prof.length >= 5) {
        this.professeurService
          .findAllSelect(prof)
          .subscribe((data) => (this.professeurs = data.results));
      }
    }
  }

  onModSearch() {
    const mod = this.form.controls['mod'].value;
    if (mod != null) {
      if (mod.length >= 5) {
        this.moduleService
          .findAllSelect(mod)
          .subscribe((data) => (this.modules = data.results));
      }
    }
  }

  onSemSearch() {
    const sem = this.form.controls['sem'].value;
    if (sem != null) {
      if (sem.length >= 5) {
        this.semestreService
          .findAllSelect(sem)
          .subscribe((data) => (this.semestres = data.results));
      }
    }
  }

  onClasseSearch() {
    const Clas = this.form.controls['Clas'].value;
    if (Clas != null) {
      if (Clas.length >= 5) {
        this.classeService
          .findAllSelect(Clas)
          .subscribe((data) => (this.classesSelect = data.results));
      }
    }
  }
  onSubmit() {
    const courCreat = this.form.value
    this.courService.create(courCreat).subscribe(data => {
      this.closeForm()
      this.router.navigateByUrl('/',{skipLocationChange:true}).then(() => {
        this.router.navigate(['/RP/cours'])
      })
    })
  }
}
