import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { ProfesseurListe } from '../../../core/models/Professeur.liste';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { ProfesseurServiceImpl } from '../../../core/services/impl/professeur.service.imp';
import { FormProfesseurComponent } from './form.professeur/form.professeur.component';

@Component({
  selector: 'app-professeurs',
  standalone: true,
  imports: [
    PaginationComponent,
    RouterLink,
    CommonModule,
    FormProfesseurComponent,
  ],
  templateUrl: './professeurs.component.html',
  styleUrl: './professeurs.component.css',
})
export class ProfesseursComponent implements OnInit {
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };

  constructor(private profService: ProfesseurServiceImpl) {}

  response?: RestResponse<ProfesseurListe[]>;
  ngOnInit(): void {
    this.refresh();
  }

  refresh(page: number = 0, telephone: string = ''): void {
    this.profService
      .findAll(page, telephone)
      .subscribe(
        (data) => (
          (this.response = data),
          (this.dataPagination.pages = data.pages!),
          (this.dataPagination.currentPage = data.currentPage!)
        )
      );
  }

  paginate(page: number) {
    this.refresh(page);
  }

  search(telephone: string) {
    if (telephone.length > 4 || telephone.length == 0) {
      this.refresh(0, telephone);
    }
  }

  // FORMULAIRE PART ON
  isFormProfesseurClosed = true;
  closeForm() {
    this.isFormProfesseurClosed = true;
  }
  openForm() {
    this.isFormProfesseurClosed = false;
  }
  // FORMULAIRE PART OFF
}
