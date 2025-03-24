import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColonyListComponent } from './colony-list.component';

describe('ColonyListComponent', () => {
  let component: ColonyListComponent;
  let fixture: ComponentFixture<ColonyListComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ColonyListComponent]
    });
    fixture = TestBed.createComponent(ColonyListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
