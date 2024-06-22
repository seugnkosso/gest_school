import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CourProfComponent } from './cour-prof.component';

describe('CourProfComponent', () => {
  let component: CourProfComponent;
  let fixture: ComponentFixture<CourProfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourProfComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(CourProfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
