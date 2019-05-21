import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListdeclarationComponent } from './listdeclaration.component';

describe('ListdeclarationComponent', () => {
  let component: ListdeclarationComponent;
  let fixture: ComponentFixture<ListdeclarationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListdeclarationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListdeclarationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
