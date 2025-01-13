import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class InventarioLibrosService {


  constructor(private http: HttpClient) {
  }

  apiUrl: string = "http://localhost:8080/api/inventarioLibros";


  loadInventario() {
    return this.http.get(this.apiUrl, {
      headers: new HttpHeaders({'Content-Type': 'application/json'}),
      withCredentials: true
    });
  }
  loadLibros() {
    return this.http.get("http://localhost:8080/api/libros");
  }
  saveInventario(credenciales: object) {
    console.log(credenciales)
    return this.http.post(this.apiUrl, credenciales)
  }

  editInventario(credenciales: object, id: number) {
    return this.http.put(`${this.apiUrl}/${id}`, credenciales, {
      headers: new HttpHeaders({'Content-Type': 'application/json'}),
      withCredentials: true
    });
  }

  deleteInventario( id: number) {
    console.log(id)
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
