import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ColonyViewComponent } from './colony-view.component';

describe('ColonyListComponent', () => {
  let component: ColonyViewComponent;
  let fixture: ComponentFixture<ColonyViewComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ColonyViewComponent]
    });
    fixture = TestBed.createComponent(ColonyViewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
