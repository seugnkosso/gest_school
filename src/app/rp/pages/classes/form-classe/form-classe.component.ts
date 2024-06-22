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
import { AnneeScolaireSelect } from '../../../../core/models/annee-scolaire.liste';
import { AttacherSelect } from '../../../../core/models/attacher.liste';
import { FiliereSelect } from '../../../../core/models/filiere.liste';
import { NiveauSelect } from '../../../../core/models/niveau.liste';
import { AttacherServiceImpl } from '../../../../core/services/impl/Attacher.service';
import { AnneeScolaireServiceImpl } from '../../../../core/services/impl/annee-scolaire.service';
import { ClasseServiceImpl } from '../../../../core/services/impl/classe.service.impl';
import { FiliereServiceImpl } from '../../../../core/services/impl/filiere.service';
import { NiveauServiceImpl } from '../../../../core/services/impl/niveau.service';

@Component({
  selector: 'app-form-classe',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, CommonModule, NgSelectModule],
  templateUrl: './form-classe.component.html',
  styleUrl: './form-classe.component.css',
})
export class FormClasseComponent {
  @Output() onCloseForm: EventEmitter<any> = new EventEmitter();
  FilieresSelect: FiliereSelect[] = [];
  niveauSelect: NiveauSelect[] = [];
  anneeScolaireSelect: AnneeScolaireSelect[] = [];
  attacherSelect: AttacherSelect[] = [];
  form = this.fb.group({
    libelle: ['', [Validators.required]],
    searchAttacher: ['', []],
    attacher: [null, [Validators.required]],
    searchFiliere: ['', []],
    filiere: [null, [Validators.required]],
    searchNiveau: ['', []],
    niveau: [null, [Validators.required]],
    searchAnnee: ['', []],
    anneeScolaire: [null, [Validators.required]],
  });
  constructor(
    private fb: FormBuilder,
    private filiereService: FiliereServiceImpl,
    private niveauService: NiveauServiceImpl,
    private anneeService: AnneeScolaireServiceImpl,
    private attacherService: AttacherServiceImpl,
    private classeService: ClasseServiceImpl,
    private router: Router
  ) {}
  onChargeLibelle() {
    if (localStorage.getItem('lib') != undefined) {
      localStorage.removeItem('lib');
    }
    if (
      this.form.controls['filiere'].value![1] != null &&
      this.form.controls['niveau'].value![1] != null
    ) {
      const Alphabet = [
        'A',
        'B',
        'C',
        'D',
        'E',
        'F',
        'G',
        'H',
        'I',
        'J',
        'K',
        'L',
        'M',
        'N',
        'O',
        'P',
        'Q',
        'R',
        'S',
        'T',
        'U',
        'V',
        'W',
        'X',
        'Y',
        'Z',
      ];
      for (let index = 0; index < Alphabet.length; index++) {
        this.classeService
          .findByLibelle(
            this.form.controls['filiere'].value![1] +
              '' +
              this.form.controls['niveau'].value![1] +
              '' +
              Alphabet[index]
          )
          .subscribe((data) => {
            if (data.results != null) {
              this.form.controls['libelle'].setValue(
                this.form.controls['filiere'].value![1] +
                  '' +
                  this.form.controls['niveau'].value![1] +
                  '' +
                  Alphabet[index + 1]
              );
              localStorage.setItem('lib', 'ok');
            }
          });
        if (localStorage.getItem('lib') != undefined) {
          break;
        }
      }
      if (localStorage.getItem('lib') == undefined) {
        this.form.controls['libelle'].setValue(
          this.form.controls['filiere'].value![1] +
            '' +
            this.form.controls['niveau'].value![1] +
            'A'
        );
      }
    }
  }

  searchAttacher() {
    const searchAttacher = this.form.controls['searchAttacher'].value;
    if (searchAttacher != null && searchAttacher.length >= 4) {
      this.attacherService
        .findAllSelect(searchAttacher)
        .subscribe((data) => (this.attacherSelect = data.results));
    }
  }
  searchAnneeScolaire() {
    const searchAnnee = this.form.controls['searchAnnee'].value;
    if (searchAnnee != null && searchAnnee.length >= 4) {
      this.anneeService
        .findAllSelect(searchAnnee)
        .subscribe((data) => (this.anneeScolaireSelect = data.results));
    }
  }
  searchNiveau() {
    const searchNiveau = this.form.controls['searchNiveau'].value;
    if (searchNiveau != null && searchNiveau.length >= 4) {
      this.niveauService
        .findAllSelect(searchNiveau)
        .subscribe((data) => (this.niveauSelect = data.results));
    }
  }
  searchFiliere() {
    const searchFiliere = this.form.controls['searchFiliere'].value;
    if (searchFiliere != null && searchFiliere.length >= 4) {
      this.filiereService
        .findAllSelect(searchFiliere)
        .subscribe((data) => (this.FilieresSelect = data.results));
    }
  }

  onSubmit() {
    this.form.controls['filiere'].setValue(
      this.form.controls['filiere'].value![0]
    );
    this.form.controls['niveau'].setValue(
      this.form.controls['niveau'].value![0]
    );
    const classeCreate = this.form.value;
    this.classeService.creat(classeCreate).subscribe((data) => {
      this.closeForm();
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
        this.router.navigate(['/RP/classes']);
      });
    });
  }

  closeForm() {
    this.onCloseForm.emit();
  }
}
