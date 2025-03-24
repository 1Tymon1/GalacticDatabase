import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpireCreateComponent } from './empire-create.component';

describe('EmpireCreateComponent', () => {
  let component: EmpireCreateComponent;
  let fixture: ComponentFixture<EmpireCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmpireCreateComponent]
    });
    fixture = TestBed.createComponent(EmpireCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
