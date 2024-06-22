import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SessionCourProfComponent } from './session-cour-prof.component';

describe('SessionCourProfComponent', () => {
  let component: SessionCourProfComponent;
  let fixture: ComponentFixture<SessionCourProfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SessionCourProfComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(SessionCourProfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
