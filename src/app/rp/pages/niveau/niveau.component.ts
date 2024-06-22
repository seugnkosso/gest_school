import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { NiveauSelect } from '../../../core/models/niveau.liste';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { NiveauServiceImpl } from '../../../core/services/impl/niveau.service';
import { FormNiveauComponent } from './form-niveau/form-niveau.component';

@Component({
  selector: 'app-niveau',
  standalone: true,
  imports: [CommonModule, PaginationComponent,FormNiveauComponent],
  templateUrl: './niveau.component.html',
  styleUrl: './niveau.component.css',
})
export class NiveauComponent implements OnInit {

  response?: RestResponse<NiveauSelect[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(private niveauService : NiveauServiceImpl) {}
  ngOnInit(): void {
    this.refresh();
  }

  refresh(page: number = 0) {
    this.niveauService.findAll(page).subscribe(
      (data)=>(
        (this.response = data),
        (this.dataPagination.pages = data.pages!),
        (this.dataPagination.currentPage = data.currentPage!)
      )
    )
  }

  paginate(page : number) {
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
