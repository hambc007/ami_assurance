import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ActualiteclientComponent } from './actualiteclient.component';

describe('ActualiteclientComponent', () => {
  let component: ActualiteclientComponent;
  let fixture: ComponentFixture<ActualiteclientComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ActualiteclientComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ActualiteclientComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
