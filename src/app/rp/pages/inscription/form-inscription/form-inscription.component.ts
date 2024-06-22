import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, Output } from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { NgSelectModule } from '@ng-select/ng-select';
import { AnneeScolaireSelect } from '../../../../core/models/annee-scolaire.liste';
import { ClasseSelect } from '../../../../core/models/classe.liste';
import { AnneeScolaireServiceImpl } from '../../../../core/services/impl/annee-scolaire.service';
import { ClasseServiceImpl } from '../../../../core/services/impl/classe.service.impl';
import { EtudiantServiceImpl } from '../../../../core/services/impl/etudiant.service';
import { InscriptionServiceImpl } from '../../../../core/services/impl/inscription.service';

@Component({
  selector: 'app-form-inscription',
  standalone: true,
  imports: [ReactiveFormsModule, FormsModule, NgSelectModule, CommonModule],
  templateUrl: './form-inscription.component.html',
  styleUrl: './form-inscription.component.css',
})
export class FormInscriptionComponent {
  classeSelects: ClasseSelect[] = [];
  anneeSelects: AnneeScolaireSelect[] = [];
  @Output() onCloseForm: EventEmitter<any> = new EventEmitter();
  @Input({ required: true }) idEtudiant?: number;
  form = this.fb.group({
    etudiant: this.fb.group({
      telephone: ['', [Validators.required, Validators.minLength(9)]],
      matricule: ['', [Validators.required]],
      nomComplet: ['', [Validators.required]],
    }),
    searchAnnee: [''],
    anneeScolaire: [null, [Validators.required]],
    searchClasse: [''],
    classe: [null, [Validators.required]],
  });

  constructor(
    private fb: FormBuilder,
    private classeService: ClasseServiceImpl,
    private anneeService: AnneeScolaireServiceImpl,
    private inscritService: InscriptionServiceImpl,
    private etudiantService: EtudiantServiceImpl,
    private router: Router
  ) {}
  get etudiant() {
    return this.form.controls['etudiant'] as FormGroup;
  }
  searchAnneeScolaire() {
    const searchAnnee = this.form.controls['searchAnnee'].value;
    if (searchAnnee != null && searchAnnee.length >= 4) {
      this.anneeService
        .findAllSelect(searchAnnee)
        .subscribe((data) => (this.anneeSelects = data.results));
    }
  }
  searchClasse() {
    const Clas = this.form.controls['searchClasse'].value;
    if (Clas != null) {
      if (Clas.length >= 5) {
        this.classeService
          .findAllSelect(Clas)
          .subscribe((data) => (this.classeSelects = data.results));
      }
    }
  }
  onMatriculeInit() {
    this.etudiant.controls['matricule'].setValue(
      'ism_' +
        this.etudiant.controls['nomComplet'].value.split(' ')[0] +
        '_' +
        this.etudiant.controls['telephone'].value
    );
  }
  onSubmit() {
    const inscription = this.form.value;
    this.inscritService.create(inscription).subscribe((data) => {
      // this.closeForm();
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
        this.router.navigate(['/RP/Inscriptions']);
      });
    });
  }
  formCharge() {
    if (this.idEtudiant != 0) {
      this.etudiantService
        .findById(this.idEtudiant!)
        .subscribe(
          (data) => (
            this.etudiant.controls['telephone'].setValue(
              data.results.telephone
            ),
            this.etudiant.controls['matricule'].setValue(
              data.results.matricule
            ),
            this.etudiant.controls['nomComplet'].setValue(
              data.results.nomComplet
            )
          )
        );
      this.idEtudiant = 0;
    }
  }
  closeForm() {
    this.onCloseForm.emit();
  }
}
