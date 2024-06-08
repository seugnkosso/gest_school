import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { AnneeScolaireSelect } from '../../../core/models/annee-scolaire.liste';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { AnneeScolaireServiceImpl } from '../../../core/services/impl/annee-scolaire.service';
import { FormAnneeScolaireComponent } from './form-annee-scolaire/form-annee-scolaire.component';

@Component({
  selector: 'app-annee-scolaire',
  standalone: true,
  imports: [CommonModule, PaginationComponent, FormAnneeScolaireComponent],
  templateUrl: './annee-scolaire.component.html',
  styleUrl: './annee-scolaire.component.css',
})
export class AnneeScolaireComponent implements OnInit {
  isFormAnnneScolaireOpen = true;
  response?: RestResponse<AnneeScolaireSelect[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(private anneeService: AnneeScolaireServiceImpl) {}
  ngOnInit(): void {
    this.refresh();
  }

  paginate(page: number) {
    this.refresh(page);
  }
  refresh(page: number = 0) {
    this.anneeService
      .findAll(page)
      .subscribe(
        (data) => (
          (this.response = data),
          (this.dataPagination.pages = data.pages!),
          (this.dataPagination.currentPage = data.currentPage!)
        )
      );
  }

  // FORM ANNEE SCOLAIRE ON
  openForm() {
    this.isFormAnnneScolaireOpen = false;
  }
  closeFormAnneeScolaire() {
    this.isFormAnnneScolaireOpen = true;
  }
  // FORM ANNEE SCOLAIRE ON
}
