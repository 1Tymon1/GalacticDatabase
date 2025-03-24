import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColonyCreateComponent } from './colony-create.component';

describe('ColonyCreateComponent', () => {
  let component: ColonyCreateComponent;
  let fixture: ComponentFixture<ColonyCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ColonyCreateComponent]
    });
    fixture = TestBed.createComponent(ColonyCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
