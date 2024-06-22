import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { FormCourComponent } from '../../../../rp/pages/cours/form.cour/form.cour.component';
import { CourListe } from '../../../models/cour.liste';

@Component({
  selector: 'app-cour-shared',
  standalone: true,
  imports: [CommonModule, FormCourComponent, RouterLink],
  templateUrl: './cour-shared.component.html',
  styleUrl: './cour-shared.component.css',
})
export class CourSharedComponent implements OnInit {
  idProf?: string | null;
  @Input({ required: true }) results?: CourListe[];
  @Output() OnOpenForm: EventEmitter<any> = new EventEmitter();
  @Output() OnSearch: EventEmitter<any> = new EventEmitter();
  constructor(private route: ActivatedRoute) {}
  ngOnInit(): void {
    this.idProf = this.route.snapshot.paramMap.get('idProf');
  }
  openClose() {
    this.OnOpenForm.emit();
  }
  search(tel: string) {
    this.OnSearch.emit(tel);
  }
}
