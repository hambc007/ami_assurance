import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { VoirreclamationComponent } from './voirreclamation.component';

describe('VoirreclamationComponent', () => {
  let component: VoirreclamationComponent;
  let fixture: ComponentFixture<VoirreclamationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ VoirreclamationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(VoirreclamationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
