import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpireEditComponent } from './empire-edit.component';

describe('EmpireEditComponent', () => {
  let component: EmpireEditComponent;
  let fixture: ComponentFixture<EmpireEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmpireEditComponent]
    });
    fixture = TestBed.createComponent(EmpireEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
