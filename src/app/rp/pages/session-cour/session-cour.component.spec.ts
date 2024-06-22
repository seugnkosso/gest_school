import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionCourComponent } from './session-cour.component';

describe('SessionCourComponent', () => {
  let component: SessionCourComponent;
  let fixture: ComponentFixture<SessionCourComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SessionCourComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SessionCourComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
