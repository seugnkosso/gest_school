import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { PaginationComponent } from '../../../core/component/pagination/pagination.component';
import { ModuleSelect } from '../../../core/models/Module.liste';
import { PaginationModel } from '../../../core/models/pagination.model';
import { RestResponse } from '../../../core/models/rest.response';
import { ModuleServiceImpl } from '../../../core/services/impl/module.service.impl';
import { FormModuleComponent } from './form-module/form-module.component';

@Component({
  selector: 'app-modules',
  standalone: true,
  imports: [CommonModule, PaginationComponent, FormModuleComponent],
  templateUrl: './modules.component.html',
  styleUrl: './modules.component.css',
})
export class ModulesComponent implements OnInit {
  response?: RestResponse<ModuleSelect[]>;
  dataPagination: PaginationModel = {
    pages: [],
    currentPage: 0,
  };
  constructor(private moduleService: ModuleServiceImpl) {}
  ngOnInit(): void {
    this.refresh();
  }
  paginate(page: number) {
    this.refresh(page);
  }
  refresh(page: number = 0) {
    this.moduleService
      .findAll(page)
      .subscribe(
        (data) => (
          (this.response = data),
          (this.dataPagination.pages = data.pages!),
          (this.dataPagination.currentPage = data.currentPage!)
        )
      );
  }

  // FORM MDULE ON
  isFormClosed = true;
  openForm() {
    this.isFormClosed = false;
  }
  closeForm() {
    this.isFormClosed = true;
  }
  // FORM MDULE OFF
}
