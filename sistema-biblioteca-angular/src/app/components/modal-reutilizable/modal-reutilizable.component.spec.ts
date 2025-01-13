import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalReutilizableComponent } from './modal-reutilizable.component';

describe('ModalReutilizableComponent', () => {
  let component: ModalReutilizableComponent;
  let fixture: ComponentFixture<ModalReutilizableComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalReutilizableComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ModalReutilizableComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
