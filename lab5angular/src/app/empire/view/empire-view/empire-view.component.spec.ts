import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpireViewComponent } from './empire-view.component';

describe('EmpireViewComponent', () => {
  let component: EmpireViewComponent;
  let fixture: ComponentFixture<EmpireViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmpireViewComponent]
    });
    fixture = TestBed.createComponent(EmpireViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
