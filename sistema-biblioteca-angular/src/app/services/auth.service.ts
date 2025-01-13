import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private storageKey = 'authUser';

  constructor(private http: HttpClient) {

  }
  apiUrl:string = 'http://localhost:8080/api/';

  loginUser(credenciales:object){
    return this.http.post(this.apiUrl + 'login',credenciales)
  }
  saveUser(user: any): void {
    localStorage.setItem(this.storageKey, JSON.stringify(user?.user));
  }

  getUser(): any {
    const user = localStorage.getItem(this.storageKey);
    return user ? JSON.parse(user) : null;
  }

  isAuthenticated(): boolean {
    return !!this.getUser();
  }
  hasRole(role: string): boolean {
    const user = this.getUser();
    console.log(user?.authorities?.some((auth: any) => auth.authority === role))
    console.log((user.authorities[0]).authority)
    return user?.authorities?.some((auth: any) => auth.authority === role);
  }
}
