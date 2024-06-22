import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { GradeSelect } from '../../../core/models/grade.liste';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { GradeServiceImpl } from '../../../core/services/impl/grade.service';
import { FormGradeComponent } from './form-grade/form-grade.component';

@Component({
  selector: 'app-grade',
  standalone: true,
  imports: [CommonModule, PaginationComponent,FormGradeComponent],
  templateUrl: './grade.component.html',
  styleUrl: './grade.component.css',
})
export class GradeComponent implements OnInit {

  response?: RestResponse<GradeSelect[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(private gradeService: GradeServiceImpl) {}

  ngOnInit(): void {
    this.refresh();
  }

  refresh(page: number = 0) {
    this.gradeService
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
    this.refresh(page);
  }

  // FORM ADD ONà
  isFormClosed = true;
  openForm() {
    this.isFormClosed = false;
  }
  closeForm() {
    this.isFormClosed = true;
    }
  // FORM ADD OFF
}
