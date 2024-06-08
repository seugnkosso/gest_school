import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import {
  FormBuilder,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Router } from '@angular/router';
import { ModuleServiceImpl } from '../../../../core/services/impl/module.service.impl';

@Component({
  selector: 'app-form-module',
  standalone: true,
  imports: [FormsModule, ReactiveFormsModule, CommonModule],
  templateUrl: './form-module.component.html',
  styleUrl: './form-module.component.css',
})
export class FormModuleComponent {
  constructor(private fb: FormBuilder,private moduleService:ModuleServiceImpl,private router:Router) {}
  @Output() onCloseForm: EventEmitter<any> = new EventEmitter();
  form = this.fb.group({
    id: [null, []],
    libelle: ['', [Validators.required]],
  });

  closeForm() {
    this.onCloseForm.emit();
  }
  onSubmit() {
    console.log('ok');
    const ModuleSelect = this.form.value
    this.moduleService.create(ModuleSelect).subscribe(data => {
      this.closeForm();
      this.router.navigateByUrl('/',{skipLocationChange:true}).then(() => {
        this.router.navigate(['/RP/modules']);
      })
    })
  }
}
