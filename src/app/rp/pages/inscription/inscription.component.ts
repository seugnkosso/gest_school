import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { InscriptionListe } from '../../../core/models/inscription.liste';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { InscriptionServiceImpl } from '../../../core/services/impl/inscription.service';
import { FormInscriptionComponent } from './form-inscription/form-inscription.component';

@Component({
  selector: 'app-inscription',
  standalone: true,
  imports: [CommonModule, PaginationComponent, FormInscriptionComponent],
  templateUrl: './inscription.component.html',
  styleUrl: './inscription.component.css',
})
export class InscriptionComponent implements OnInit {
  idEtudiant?: number = 0;
  response?: RestResponse<InscriptionListe[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(private insService: InscriptionServiceImpl) {}

  ngOnInit(): void {
    this.refresh();
  }
  refresh(page: number = 0, matricule: string = '') {
    this.insService
      .findall(page, matricule)
      .subscribe(
        (data) => (
          (this.response = data),
          (this.dataPagination.pages = data.pages!),
          (this.dataPagination.currentPage = data.currentPage!)
        )
      );
  }

  search(matricule: string) {
    this.refresh(0, matricule);
  }
  paginate(page: number) {
    this.refresh(page);
  }
  // FORM CONTRON ON
  isFormClosed = true;

  openForm() {
    this.isFormClosed = false;
  }
  closeForm() {
    this.isFormClosed = true;
  }
  reinscription(id: number) {
    this.idEtudiant = id;
    this.isFormClosed = false;
  }
  // FORM CONTRON OFF
}
