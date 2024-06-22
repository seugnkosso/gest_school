import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormSessionCourComponent } from './form-session-cour.component';

describe('FormSessionCourComponent', () => {
  let component: FormSessionCourComponent;
  let fixture: ComponentFixture<FormSessionCourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormSessionCourComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormSessionCourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
