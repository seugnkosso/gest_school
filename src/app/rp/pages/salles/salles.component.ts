import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { SalleListe } from '../../../core/models/salle.liste';
import { SalleServiceImpl } from '../../../core/services/impl/salle.service.impl ';
import { FormSalleComponent } from './form-salle/form-salle.component';

@Component({
  selector: 'app-salles',
  standalone: true,
  imports: [CommonModule, PaginationComponent, FormSalleComponent],
  templateUrl: './salles.component.html',
  styleUrl: './salles.component.css',
})
export class SallesComponent implements OnInit {
  constructor(private salleService: SalleServiceImpl) {}
  response?: RestResponse<SalleListe[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  ngOnInit(): void {
    this.refresh();
  }

  refresh(page: number = 0): void {
    this.salleService
      .findall(page)
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

  // Form Salle ON
  isClosedForm = true;
  openForm() {
    this.isClosedForm = false;
  }
  closeForm() {
    this.isClosedForm = true;
  }
  // Form Salle Off
}
