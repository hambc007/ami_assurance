import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjoutercontratComponent } from './ajoutercontrat.component';

describe('AjoutercontratComponent', () => {
  let component: AjoutercontratComponent;
  let fixture: ComponentFixture<AjoutercontratComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjoutercontratComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjoutercontratComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
