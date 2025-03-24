import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmpireListComponent } from './empire-list.component';

describe('EmpireListComponent', () => {
  let component: EmpireListComponent;
  let fixture: ComponentFixture<EmpireListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EmpireListComponent]
    });
    fixture = TestBed.createComponent(EmpireListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
