import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormNiveauComponent } from './form-niveau.component';

describe('FormNiveauComponent', () => {
  let component: FormNiveauComponent;
  let fixture: ComponentFixture<FormNiveauComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormNiveauComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormNiveauComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
