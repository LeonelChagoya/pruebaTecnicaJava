import {Component, OnInit} from '@angular/core';
import {FormsModule} from "@angular/forms";
import {ModalReutilizableComponent} from "../../components/modal-reutilizable/modal-reutilizable.component";
import {TablaReusableComponent} from "../../components/tabla-reusable/tabla-reusable.component";
import {UsuariosService} from '../../services/usuarios.service';

@Component({
  selector: 'app-usuarios',
    imports: [
        FormsModule,
        ModalReutilizableComponent,
        TablaReusableComponent
    ],
  templateUrl: './usuarios.component.html',
  standalone: true,
  styleUrl: './usuarios.component.css'
})
export class UsuariosComponent  implements  OnInit{
  columnas = [
    { field: 'username', header: 'UserName' },
    { field: 'nombre', header: 'Nombre' },
    { field: 'apellidoPaterno', header: 'Apellido Paterno' },
    { field: 'apellidoMaterno', header: 'Apellido Materno' },
    { field: 'email', header: 'Email' },
  ];
  data: any[] = []

  isModalVisible = false;
  modalTitle = '';
  tablaTitle:string ='Tabla Datos Usuarios'
  formData: any = {};
  constructor(private usuarioService: UsuariosService) {
  }
  ngOnInit() {
    this.loadUsuarios()
  }

  loadUsuarios():void{
    this.usuarioService.loadUsuarios().subscribe(
      (res:any)=>{
        this.data = res;
      }
    )
  }


  onEdit(item: any): void {
    this.formData = { ...item };
    this.modalTitle = 'Editar Usuario';
    this.isModalVisible = true;
  }

  onDelete(item:any): void {
    console.log(item)
    this.usuarioService.deleteUsuario(item.id).subscribe(
      (res: any) => {
        this.loadUsuarios();
      }
    )
  }

  onCreate(): void {
    this.formData = {};
    this.modalTitle = 'Crear  Usuario';
    this.isModalVisible = true;
  }

  closeModal(): void {
    this.isModalVisible = false;
  }

  handleFormSubmit(): void {
    if (this.modalTitle === 'Editar Usuario') {
      this.usuarioService.editUsuarios(this.formData, this.formData.id).subscribe(
        (res: any) => {
          this.loadUsuarios();
        }
      );
    } else {
      this.usuarioService.saveUsuarios({ ...this.formData }).subscribe(
        (res:any) => {
          this.loadUsuarios();
        }
      )
    }
    this.closeModal();
  }
}
