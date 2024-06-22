import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LayoutComponentRp } from './layout.component';

describe('LayoutComponentRp', () => {
  let component: LayoutComponentRp;
  let fixture: ComponentFixture<LayoutComponentRp>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [LayoutComponentRp],
    }).compileComponents();

    fixture = TestBed.createComponent(LayoutComponentRp);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
