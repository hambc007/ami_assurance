import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailcontratComponent } from './detailcontrat.component';

describe('DetailcontratComponent', () => {
  let component: DetailcontratComponent;
  let fixture: ComponentFixture<DetailcontratComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DetailcontratComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailcontratComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
