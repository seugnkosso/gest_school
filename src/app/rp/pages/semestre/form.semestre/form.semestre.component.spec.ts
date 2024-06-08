import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormSemestreComponent } from './form.semestre.component';

describe('FormSemestreComponent', () => {
  let component: FormSemestreComponent;
  let fixture: ComponentFixture<FormSemestreComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormSemestreComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormSemestreComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
