import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DormSpecialiteComponent } from './dorm-specialite.component';

describe('DormSpecialiteComponent', () => {
  let component: DormSpecialiteComponent;
  let fixture: ComponentFixture<DormSpecialiteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DormSpecialiteComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DormSpecialiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
