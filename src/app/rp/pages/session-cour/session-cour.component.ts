import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { SessionCourListe } from '../../../core/models/sessionCour.liste';
import { SessionCoureServiceImpl } from '../../../core/services/impl/sessionCour.service.impl ';
import { SessionCourSharedComponent } from '../../../core/shared/SessionCour/session-cour-shared/session-cour-shared.component';
import { FormSessionCourComponent } from './form-session-cour/form-session-cour.component';

@Component({
  selector: 'app-session-cour',
  standalone: true,
  imports: [
    CommonModule,
    PaginationComponent,
    FormSessionCourComponent,
    SessionCourSharedComponent,
  ],
  templateUrl: './session-cour.component.html',
  styleUrl: './session-cour.component.css',
})
export class SessionCourComponent implements OnInit {
  idCour: string | null = '';
  dateDebut?: string;
  dateFin?: string;
  response?: RestResponse<SessionCourListe[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(
    private route: ActivatedRoute,
    private sessionCourService: SessionCoureServiceImpl
  ) {}
  ngOnInit(): void {
    this.idCour = this.route.snapshot.paramMap.get('idCour');
    this.refresh();
  }

  refresh(
    page: number = 0,
    dateDebut: any = '0000-00-00',
    dateFin: any = '9999-00-00'
  ) {
    this.sessionCourService
      .findAll(page, this.idCour!, dateDebut, dateFin)
      .subscribe(
        (data) => (
          (this.response = data),
          (this.dataPagination.pages = data.pages!),
          (this.dataPagination.currentPage = data.currentPage!)
        )
      );
  }
  dateFinChange(dateFin: any) {
    this.dateFin = dateFin == '' ? '9999-00-00' : dateFin;
    this.refresh(0, this.dateDebut, this.dateFin);
  }
  dateDebutChange(dateDebut: any) {
    this.dateDebut = dateDebut == '' ? '0000-00-00' : dateDebut;
    this.refresh(0, this.dateDebut, this.dateFin);
  }

  paginate(page: number) {
    this.refresh(page);
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
