import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormCourComponent } from './form.cour.component';

describe('FormCourComponent', () => {
  let component: FormCourComponent;
  let fixture: ComponentFixture<FormCourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormCourComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormCourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
