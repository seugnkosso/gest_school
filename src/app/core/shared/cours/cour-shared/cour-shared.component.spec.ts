import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourSharedComponent } from './cour-shared.component';

describe('CourSharedComponent', () => {
  let component: CourSharedComponent;
  let fixture: ComponentFixture<CourSharedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourSharedComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CourSharedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
