import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { ClasseListe } from '../../../core/models/classe.liste';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { ClasseServiceImpl } from '../../../core/services/impl/classe.service.impl';
import { FormClasseComponent } from './form-classe/form-classe.component';

@Component({
  selector: 'app-classes',
  standalone: true,
  imports: [CommonModule, PaginationComponent, FormClasseComponent],
  templateUrl: './classes.component.html',
  styleUrl: './classes.component.css',
})
export class ClassesComponent implements OnInit {
  response?: RestResponse<ClasseListe[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(private classeService: ClasseServiceImpl) {}

  ngOnInit(): void {
    this.refresh();
  }
  refresh(page: number = 0): void {
    this.classeService
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

  // FORM AD CLASSE ON
  isformClosed = true;
  closeFormClasse() {
    this.isformClosed = true;
  }
  openFormClasses() {
    this.isformClosed = false;
  }
  // FORM AD CLASSE OFF
}
