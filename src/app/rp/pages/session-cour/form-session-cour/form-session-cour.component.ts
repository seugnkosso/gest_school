import { CommonModule } from '@angular/common';
import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormsModule,
  ReactiveFormsModule,
  ValidationErrors,
  ValidatorFn,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { NgSelectModule } from '@ng-select/ng-select';
import { SalleListe } from '../../../../core/models/salle.liste';
import { SalleServiceImpl } from '../../../../core/services/impl/salle.service.impl ';
import { SessionCoureServiceImpl } from '../../../../core/services/impl/sessionCour.service.impl ';

@Component({
  selector: 'app-form-session-cour',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, CommonModule, NgSelectModule],
  templateUrl: './form-session-cour.component.html',
  styleUrl: './form-session-cour.component.css',
})
export class FormSessionCourComponent implements OnInit {
  @Output() onCloseForm: EventEmitter<any> = new EventEmitter();
  idCour: string | null = '';
  isSessionProfExists: boolean = false;
  isSessionClasseExists: boolean = false;
  salleSelects?: SalleListe[];
  form = this.fb.group(
    {
      date: [null, [Validators.required]],
      heureDebut: [null, [Validators.required]],
      heureFin: [null, [Validators.required]],
      searchSalle: [''],
      salle: ['', [Validators.required]],
      cour: ['', []],
      etat: [null, [Validators.required]],
    },
    { validators: this.validateHeureDebut() }
  );
  constructor(
    private fb: FormBuilder,
    private sessionService: SessionCoureServiceImpl,
    private salleService: SalleServiceImpl,
    private sessionCourService: SessionCoureServiceImpl,
    private route: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.idCour = this.route.snapshot.paramMap.get('idCour');
  }

  closeForm() {
    this.onCloseForm.emit();
  }

  onSubmit() {
    this.form.controls['cour'].setValue(this.idCour);
    const sessioCourCreate = this.form.value;
    this.sessionCourService.create(sessioCourCreate).subscribe((data) => {
      this.closeForm();
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
        this.router.navigate(['/RP/sessionCours/cour/' + this.idCour]);
      });
    });
  }

  onChangeHeureDebut() {
    this.isExistSessionFunction();
  }
  onChangeHeureFin() {
    this.isExistSessionFunction();
  }
  onChangeDate() {
    this.isExistSessionFunction();
  }
  isExistSessionFunction() {
    this.sessionService
      .findSessionExistErrors(
        this.form.controls['date'].value!,
        this.form.controls['heureDebut'].value!,
        this.form.controls['heureFin'].value!,
        this.idCour!
      )
      .subscribe((data) => {
        (this.isSessionClasseExists = data.results.SessionClasseExist!),
          (this.isSessionProfExists = data.results.SessionProfExist!);
      });
  }
  searchSalle() {
    const searchSalle = this.form.controls['searchSalle'].value!;
    if (searchSalle.length > 4) {
      this.salleService
        .findAllBylibelle(
          this.form.controls['searchSalle'].value!,
          this.form.controls['heureDebut'].value!,
          this.form.controls['heureFin'].value!,
          this.form.controls['date'].value!
        )
        .subscribe((data) => (this.salleSelects = data.results!));
    }
  }

  validateHeureDebut(): ValidatorFn {
    return (control: AbstractControl): ValidationErrors | null => {
      const heureDebut = control.get('heureDebut')?.value;
      const heureFin = control.get('heureFin')?.value;
      if (heureFin <= heureDebut) {
        return { heureNotValid: true };
      }
      return null;
    };
  }

  onChangeEtat() {
    const etat = this.form.controls['etat'].value!;
    if (etat === 'en ligne') {
      this.form.controls['salle'].setValue('0');
    }else{
      this.form.controls['salle'].setValue(null);
    }
  }
}
