import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormFiliereComponent } from './form-filiere.component';

describe('FormFiliereComponent', () => {
  let component: FormFiliereComponent;
  let fixture: ComponentFixture<FormFiliereComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormFiliereComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormFiliereComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
