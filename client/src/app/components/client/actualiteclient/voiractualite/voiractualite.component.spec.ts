import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VoiractualiteComponent } from './voiractualite.component';

describe('VoiractualiteComponent', () => {
  let component: VoiractualiteComponent;
  let fixture: ComponentFixture<VoiractualiteComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VoiractualiteComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VoiractualiteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
