import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { SemestreSelect } from '../../../../core/models/semestre.liste';
import { SemestreServiceImpl } from '../../../../core/services/impl/semestre.service.impl';

@Component({
  selector: 'app-form-semestre',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './form.semestre.component.html',
  styleUrl: './form.semestre.component.css',
})
export class FormSemestreComponent {
  constructor(private semestreService: SemestreServiceImpl,private router:Router) {}

  @Output() OnCloseFormSemestre: EventEmitter<null> = new EventEmitter<null>();
  semestreSelect: SemestreSelect = {
    libelle: '',
  };
  onSubmit() {
    this.semestreService.create(this.semestreSelect).subscribe((data) => {
      this.router.navigateByUrl('/RP/semestres');
    });
  }
  closeForm() {
    this.OnCloseFormSemestre.emit();
  }
}
