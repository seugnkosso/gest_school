import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import {
  FormBuilder,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-dorm-specialite',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, CommonModule],
  templateUrl: './dorm-specialite.component.html',
  styleUrl: './dorm-specialite.component.css',
})
export class DormSpecialiteComponent {
  @Output() onCloseForm: EventEmitter<any> = new EventEmitter();
  form = this.fb.group({
    id: [],
    libelle: ['', [Validators.required]],
  });
  constructor(private fb: FormBuilder) {}
  closeForm() {
    this.onCloseForm.emit();
  }
  onSubmit() {
    throw new Error('Method not implemented.');
  }
}
