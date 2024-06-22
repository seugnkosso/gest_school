import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { FiliereSelect } from '../../../core/models/filiere.liste';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { FiliereServiceImpl } from '../../../core/services/impl/filiere.service';
import { FormFiliereComponent } from './form-filiere/form-filiere.component';

@Component({
  selector: 'app-filiere',
  standalone: true,
  imports: [CommonModule, PaginationComponent, FormFiliereComponent],
  templateUrl: './filiere.component.html',
  styleUrl: './filiere.component.css',
})
export class FiliereComponent implements OnInit {
  response?: RestResponse<FiliereSelect[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(private filiereService: FiliereServiceImpl) {}
  ngOnInit(): void {
    this.refresh();
  }

  refresh(page: number = 0): void {
    this.filiereService
      .findAll(page)
      .subscribe(
        (data) => (
          (this.response = data),
          (this.dataPagination.pages = data.pages!),
          (this.dataPagination.currentPage = data.currentPage!)
        )
      );
  }

  paginate(page: number) {
    this.refresh(page)
  }

  // FORM ADD ON
  isFormClosed = true;
  openForm() {
    this.isFormClosed = false;
  }
  closeForm() {
    this.isFormClosed = true;
  }
  // FORM ADD OFF
}
