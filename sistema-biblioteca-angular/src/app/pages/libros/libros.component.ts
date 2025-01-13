import {Component, OnInit} from '@angular/core';
import {TablaReusableComponent} from '../../components/tabla-reusable/tabla-reusable.component';
import {ModalReutilizableComponent} from '../../components/modal-reutilizable/modal-reutilizable.component';
import {FormsModule} from '@angular/forms';
import {LibrosService} from '../../services/libros.service';


@Component({
  selector: 'app-libros',
  imports: [
    TablaReusableComponent,
    ModalReutilizableComponent,
    FormsModule
  ],
  templateUrl: './libros.component.html',
  standalone: true,
  styleUrl: './libros.component.css'
})
export class LibrosComponent implements OnInit{
  columnas = [
    { field: 'titulo', header: 'Título' },
    { field: 'autor', header: 'Autor' },
    { field: 'genero', header: 'Género' },
    { field: 'isbn', header: 'ISBN' },
    { field: 'fechaPublicacion', header: 'Fecha de Publicación' },
    { field: 'descripcion', header: 'Descripción' },
  ];
  data: any[] = []

  isModalVisible = false;
  modalTitle = '';
  tablaTitle:string ='Tabla Datos Libros'
  formData: any = {};
  constructor(private librosService: LibrosService) {
  }
  ngOnInit() {
    this.loadLibros()
  }

  loadLibros():void{
    this.librosService.loadLibros().subscribe(
      (res:any)=>{
        this.data = res;
      }
    )
  }


  onEdit(item: any): void {
    this.formData = { ...item };
    this.modalTitle = 'Editar Libro';
    this.isModalVisible = true;
  }

  onDelete(item:any): void {
    console.log(item)
    this.librosService.deleteLibro(item.id).subscribe(
      (res: any) => {
        this.loadLibros();
      }
    )
  }

  onCreate(): void {
    this.formData = {};
    this.modalTitle = 'Crear registro de libro';
    this.isModalVisible = true;
  }

  closeModal(): void {
    this.isModalVisible = false;
  }

  handleFormSubmit(): void {
    if (this.modalTitle === 'Editar Libro') {
      this.librosService.editLibro(this.formData, this.formData.id).subscribe(
        (res: any) => {
          this.loadLibros();
        }
      );
    } else {
      this.librosService.saveLibro({ ...this.formData }).subscribe(
        (res:any) => {
          this.loadLibros();
        }
      )
    }
    this.closeModal();
  }
}
