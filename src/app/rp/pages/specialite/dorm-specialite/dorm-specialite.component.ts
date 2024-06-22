import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import {
  FormBuilder,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { SpecialiteServiceImpl } from '../../../../core/services/impl/specialite.service';

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
  constructor(
    private fb: FormBuilder,
    private specService: SpecialiteServiceImpl,
    private router: Router
  ) {}
  closeForm() {
    this.onCloseForm.emit();
  }
  onSubmit() {
    const specialiteSelect = this.form.value;
    this.specService.create(specialiteSelect).subscribe((data) => {
      this.closeForm();
      this.router.navigateByUrl('/', { skipLocationChange: true }).then(() => {
        this.router.navigate(['/RP/specialites']);
      });
    });
  }
}
