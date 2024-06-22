import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionCourSharedComponent } from './session-cour-shared.component';

describe('SessionCourSharedComponent', () => {
  let component: SessionCourSharedComponent;
  let fixture: ComponentFixture<SessionCourSharedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SessionCourSharedComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SessionCourSharedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
