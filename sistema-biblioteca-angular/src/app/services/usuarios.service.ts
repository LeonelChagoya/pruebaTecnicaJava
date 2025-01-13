import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {


  constructor(private http: HttpClient) {
  }

  apiUrl: string = "http://localhost:8080/api/usuarios";


  loadUsuarios() {
    return this.http.get(this.apiUrl, {
      headers: new HttpHeaders({'Content-Type': 'application/json'}),
      withCredentials: true
    });
  }

  saveUsuarios(credenciales: object) {
    return this.http.post(this.apiUrl, credenciales)
  }

  editUsuarios(credenciales: object, id: number) {
    return this.http.put(`${this.apiUrl}/${id}`, credenciales, {
      headers: new HttpHeaders({'Content-Type': 'application/json'}),
      withCredentials: true
    });
  }

  deleteUsuario( id: number) {
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
