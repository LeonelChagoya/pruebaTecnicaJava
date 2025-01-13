import { Routes } from '@angular/router';
import {LoginComponent} from './pages/login/login.component';
import {LayoutComponent} from './pages/layout/layout.component';
import {DashboardComponent} from './pages/dashboard/dashboard.component';
import {LibrosComponent} from './pages/libros/libros.component';
import {UsuariosComponent} from './pages/usuarios/usuarios.component';
import {InventarioLibrosComponent} from './pages/inventario-libros/inventario-libros.component';
import {AuthGuard} from './guards/auth-guard.guard';

export const routes: Routes = [
  {
    path:'',
    redirectTo:'login',
    pathMatch:'full',
  },
  {
    path:'login',
    component:LoginComponent,
  },
  {
    path:'',
    component:LayoutComponent,
    children:[
      {
        path:'dashboard',
        component:DashboardComponent,
        canActivate:[AuthGuard]
      },
      {
        path:'libros',
        component:LibrosComponent,
        canActivate:[AuthGuard]
      },
      {
        path:'usuarios',
        component:UsuariosComponent,
        canActivate:[AuthGuard]
      },
      {
        path:'inventario-libros',
        component:InventarioLibrosComponent,
        canActivate:[AuthGuard]
      },
    ]
  }

];
