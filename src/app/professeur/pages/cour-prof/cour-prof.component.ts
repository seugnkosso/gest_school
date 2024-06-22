import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { CourListe } from '../../../core/models/cour.liste';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { CourServiceImpl } from '../../../core/services/impl/cour.service.impl';
import { CourSharedComponent } from '../../../core/shared/cours/cour-shared/cour-shared.component';

@Component({
  selector: 'app-cour-prof',
  standalone: true,
  imports: [PaginationComponent, CourSharedComponent],
  templateUrl: './cour-prof.component.html',
  styleUrl: './cour-prof.component.css',
})
export class CourProfComponent implements OnInit {
  idProf?: string | null;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  reponse?: RestResponse<CourListe[]>;
  constructor(
    private courService: CourServiceImpl,
    private route: ActivatedRoute
  ) {}
  ngOnInit(): void {
    this.idProf = this.route.snapshot.paramMap.get('idProf');
    this.refresh();
  }

  refresh(page: number = 0, tel: string = '') {
    this.courService
      .findallByProfId(page, this.idProf!, tel)
      .subscribe(
        (data) => (
          (this.reponse = data),
          (this.dataPagination.pages = data.pages!),
          (this.dataPagination.currentPage = data.currentPage!)
        )
      );
  }
  search(page: any) {
    this.refresh(0, page);
  }
  paginate(page: number) {
    this.refresh(page, '');
  }
}
