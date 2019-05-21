import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AjouterresultatComponent } from './ajouterresultat.component';

describe('AjouterresultatComponent', () => {
  let component: AjouterresultatComponent;
  let fixture: ComponentFixture<AjouterresultatComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AjouterresultatComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AjouterresultatComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
