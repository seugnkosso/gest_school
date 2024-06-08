import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { SemestreSelect } from '../../../core/models/semestre.liste';
import { AuthentificateService } from '../../../core/services/auth/authentificate.service';
import { SemestreServiceImpl } from '../../../core/services/impl/semestre.service.impl';
import { FormSemestreComponent } from './form.semestre/form.semestre.component';

@Component({
  selector: 'app-semestre',
  standalone: true,
  imports: [
    PaginationComponent,
    RouterLink,
    FormSemestreComponent,
    CommonModule,
  ],
  templateUrl: './semestre.component.html',
  styleUrl: './semestre.component.css',
})
export class SemestreComponent implements OnInit {
  auth?: AuthentificateService;
  response?: RestResponse<SemestreSelect[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(private semService: SemestreServiceImpl) {}
  ngOnInit(): void {
    this.refresh();
  }
  refresh(page: number = 0): void {
    this.semService
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

  // FORM SEMESTRE PART ON
  isFormSemestreClosed = true;

  openFormSemestre() {
    this.isFormSemestreClosed = false;
  }
  closeFormSemestre() {
    this.isFormSemestreClosed = true;
  }
  // FORM SEMESTRE PART OFF
}
