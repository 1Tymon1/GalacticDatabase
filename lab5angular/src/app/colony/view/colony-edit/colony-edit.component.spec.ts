import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColonyEditComponent } from './colony-edit.component';

describe('ColonyEditComponent', () => {
  let component: ColonyEditComponent;
  let fixture: ComponentFixture<ColonyEditComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ColonyEditComponent]
    });
    fixture = TestBed.createComponent(ColonyEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
