import { Component } from '@angular/core';
import {FormControl, FormsModule, ReactiveFormsModule, Validators} from '@angular/forms';
import { Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {AuthService} from '../../services/auth.service';


@Component({
  selector: 'app-login',
  imports: [
    ReactiveFormsModule,
    FormsModule
  ],
  templateUrl: './login.component.html',
  standalone: true,
  styleUrl: './login.component.css'
})
export class LoginComponent {

  userLoginObj: any ={
    username:'',
    password:''
  }
  constructor( private router: Router, private authServ:AuthService) {
  }
  onLogin(): void {
    this.authServ.loginUser(this.userLoginObj).subscribe((res:any)=>{
      console.log(res)
      this.authServ.saveUser(res);
      this.router.navigateByUrl("/dashboard");
    })

  }
}
