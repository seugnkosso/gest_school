import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutProfComponent } from './layout-prof.component';

describe('LayoutProfComponent', () => {
  let component: LayoutProfComponent;
  let fixture: ComponentFixture<LayoutProfComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LayoutProfComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LayoutProfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
