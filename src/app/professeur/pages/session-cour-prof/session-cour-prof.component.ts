import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { SessionCourListe } from '../../../core/models/sessionCour.liste';
import { SessionCoureServiceImpl } from '../../../core/services/impl/sessionCour.service.impl ';
import { SessionCourSharedComponent } from '../../../core/shared/SessionCour/session-cour-shared/session-cour-shared.component';

@Component({
  selector: 'app-session-cour-prof',
  standalone: true,
  imports: [PaginationComponent, SessionCourSharedComponent],
  templateUrl: './session-cour-prof.component.html',
  styleUrl: './session-cour-prof.component.css',
})
export class SessionCourProfComponent {
  idCour: string | null = '';
  idProf: string | null = '';
  dateDebut?: string = '0000-00-00';
  dateFin?: string = '9999-00-00';
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
    this.idProf = this.route.snapshot.paramMap.get('idProf');
    this.refresh();
  }

  refresh(page: number = 0) {
    this.sessionCourService
      .findAllByProf(
        page,
        this.idCour!,
        this.idProf!,
        this.dateDebut,
        this.dateFin
      )
      .subscribe(
        (data) => (
          (this.response = data),
          (this.dataPagination.pages = data.pages!),
          (this.dataPagination.currentPage = data.currentPage!)
        )
      );
  }
  dateFinChange(dateFin: any) {
    this.dateFin = dateFin == '' ? '0000-00-00' : dateFin;
    this.refresh();
  }
  dateDebutChange(dateDebut: any) {
    this.dateDebut = dateDebut == '' ? '0000-00-00' : dateDebut;
    this.refresh();
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
