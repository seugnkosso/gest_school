import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { SpecialiteSelect } from '../../../core/models/specialte.liste';
import { SpecialiteServiceImpl } from '../../../core/services/impl/specialite.service';
import { DormSpecialiteComponent } from './dorm-specialite/dorm-specialite.component';

@Component({
  selector: 'app-specialite',
  standalone: true,
  imports: [CommonModule, PaginationComponent, DormSpecialiteComponent],
  templateUrl: './specialite.component.html',
  styleUrl: './specialite.component.css',
})
export class SpecialiteComponent implements OnInit {
  response?: RestResponse<SpecialiteSelect[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(private specService: SpecialiteServiceImpl) {}
  ngOnInit(): void {
    this.refreh();
  }

  refreh(page: number = 0) {
    this.specService
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
    this.refreh(page);
  }

  // FORM ADD ON
  isFormClose = true;
  openForm() {
    this.isFormClose = false;
  }
  closeForm() {
    this.isFormClose = true;
  }
  // FORM ADD OFF
}
