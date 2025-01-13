import { Injectable } from '@angular/core';
import {HttpClient,HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LibrosService {

  constructor(private http: HttpClient) {
  }

  apiUrl: string = "http://localhost:8080/api/libros";


  loadLibros() {
    return this.http.get(this.apiUrl, {
      headers: new HttpHeaders({'Content-Type': 'application/json'}),
      withCredentials: true
    });
  }

  saveLibro(credenciales: object) {
    console.log(credenciales)
    return this.http.post(this.apiUrl, credenciales)
  }

  editLibro(credenciales: object, id: number) {
    return this.http.put(`${this.apiUrl}/${id}`, credenciales, {
      headers: new HttpHeaders({'Content-Type': 'application/json'}),
      withCredentials: true
    });
  }

  deleteLibro( id: number) {
console.log(id)
    return this.http.delete(`${this.apiUrl}/${id}`);
  }
}
