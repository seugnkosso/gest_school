import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormAnneeScolaireComponent } from './form-annee-scolaire.component';

describe('FormAnneeScolaireComponent', () => {
  let component: FormAnneeScolaireComponent;
  let fixture: ComponentFixture<FormAnneeScolaireComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormAnneeScolaireComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormAnneeScolaireComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
