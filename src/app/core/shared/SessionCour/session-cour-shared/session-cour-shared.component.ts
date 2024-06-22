import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SessionCourListe } from '../../../models/sessionCour.liste';

@Component({
  selector: 'app-session-cour-shared',
  standalone: true,
  imports: [],
  templateUrl: './session-cour-shared.component.html',
  styleUrl: './session-cour-shared.component.css',
})
export class SessionCourSharedComponent implements OnInit {
  idUser?: String | null;
  @Input({ required: true }) results?: SessionCourListe[];
  @Output() OnOpenForm: EventEmitter<any> = new EventEmitter();
  @Output() OnDateDebutChange: EventEmitter<any> = new EventEmitter();
  @Output() OnDateFinChange: EventEmitter<any> = new EventEmitter();
  openForm() {
    this.OnOpenForm.emit();
  }
  constructor(private route: ActivatedRoute) {}
  ngOnInit(): void {
    this.idUser = this.route.snapshot.paramMap.get('idProf');
  }
  OnFinChange(dateFin: string) {
    this.OnDateFinChange.emit(dateFin);
  }
  OnDebutChange(dateDebut: string) {
    this.OnDateDebutChange.emit(dateDebut);
  }
}
