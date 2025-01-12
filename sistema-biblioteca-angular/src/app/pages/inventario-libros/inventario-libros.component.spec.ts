import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InventarioLibrosComponent } from './inventario-libros.component';

describe('InventarioLibrosComponent', () => {
  let component: InventarioLibrosComponent;
  let fixture: ComponentFixture<InventarioLibrosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [InventarioLibrosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(InventarioLibrosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
