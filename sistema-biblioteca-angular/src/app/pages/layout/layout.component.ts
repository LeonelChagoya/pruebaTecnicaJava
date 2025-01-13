import { Component } from '@angular/core';
import {Router, RouterLink, RouterModule, RouterOutlet} from '@angular/router';

@Component({
  selector: 'app-layout',
  imports: [RouterOutlet,RouterLink],
  templateUrl: './layout.component.html',
  standalone: true,
  styleUrl: './layout.component.css'
})
export class LayoutComponent {
  constructor(private router: Router) {
  }
  onLogout(): void {

    localStorage.removeItem('authUser');
    this.router.navigateByUrl('/login');
  }
}
