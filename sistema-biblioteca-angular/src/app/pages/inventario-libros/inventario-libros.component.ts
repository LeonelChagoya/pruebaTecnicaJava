import {Component, OnInit} from '@angular/core';
import {InventarioLibrosService} from '../../services/inventario-libros.service';
import {FormsModule} from '@angular/forms';
import {ModalReutilizableComponent} from '../../components/modal-reutilizable/modal-reutilizable.component';
import {TablaReusableComponent} from '../../components/tabla-reusable/tabla-reusable.component';
import {CommonModule} from '@angular/common';

@Component({
  selector: 'app-inventario-libros',
  imports: [
    FormsModule,
    ModalReutilizableComponent,
    TablaReusableComponent,
    CommonModule
  ],
  templateUrl: './inventario-libros.component.html',
  standalone: true,
  styleUrl: './inventario-libros.component.css'
})
export class InventarioLibrosComponent implements OnInit{
  columnas = [
    { field: 'titulo', header: 'Título' },
    { field: 'cantidadTotal', header: 'Cantidad Total' },
    { field: 'cantidadDisponible', header: 'Cantidad Disponible' },
  ];
  data: any[] = []
  libros: any[] = [];
  isModalVisible = false;
  modalTitle = '';
  tablaTitle:string ='Tabla Datos Inventario de Libros'
  formData: any = {};
  constructor(private inventarioLibrosSer: InventarioLibrosService) {
  }
  ngOnInit() {
    this.loadLibros()
    this.loadSelectLibros()
  }

  loadLibros():void{
    this.inventarioLibrosSer.loadInventario().subscribe(
      (res:any)=>{
        this.data = res;
      }
    )
  }
  loadSelectLibros(): void {
    this.inventarioLibrosSer.loadLibros().subscribe(
      (res: any) => {
        console.log(res)
        this.libros = res;
      }
    )
  }

  onEdit(item: any): void {
    this.formData = { ...item };
    this.modalTitle = 'Editar Inventario';
    this.isModalVisible = true;
  }

  onDelete(item:any): void {
    this.inventarioLibrosSer.deleteInventario(item.id).subscribe(
      (res: any) => {
        this.loadLibros();
      }
    )
  }

  onCreate(): void {
    this.formData = {};
    this.modalTitle = 'Crear registro de inventario';
    this.isModalVisible = true;
  }

  closeModal(): void {
    this.isModalVisible = false;
  }

  handleFormSubmit(): void {
    if (this.modalTitle === 'Editar Inventario') {
      this.inventarioLibrosSer.editInventario(this.formData, this.formData.id).subscribe(
        (res: any) => {
          this.loadLibros();
        }
      );
    } else {
      this.inventarioLibrosSer.saveInventario({ ...this.formData }).subscribe(
        (res:any) => {
          this.loadLibros();
        }
      )
    }
    this.closeModal();
  }
}
