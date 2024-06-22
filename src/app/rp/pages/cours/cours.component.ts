import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { CourListe } from '../../../core/models/cour.liste';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { CourServiceImpl } from '../../../core/services/impl/cour.service.impl';
import { CourSharedComponent } from '../../../core/shared/cours/cour-shared/cour-shared.component';
import { FormCourComponent } from './form.cour/form.cour.component';

@Component({
  selector: 'app-cours',
  standalone: true,
  templateUrl: './cours.component.html',
  styleUrl: './cours.component.css',
  imports: [
    CommonModule,
    PaginationComponent,
    FormCourComponent,
    RouterLink,
    CourSharedComponent,
  ],
})
export class CoursComponent implements OnInit {
  response?: RestResponse<CourListe[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(private courService: CourServiceImpl) {}
  ngOnInit(): void {
    this.refresh();
  }

  refresh(page: number = 0, telephone: string = '') {
    this.courService
      .findall(page, telephone)
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

  // FORM ADD ON
  isFormClosed = true;
  closeForm() {
    this.isFormClosed = true;
  }
  openClose() {
    this.isFormClosed = false;
  }
  // FORM ADD OFF
}
