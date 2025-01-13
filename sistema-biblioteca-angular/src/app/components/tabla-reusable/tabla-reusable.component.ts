import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {NgForOf, NgIf} from '@angular/common';
import {AuthService} from '../../services/auth.service';

@Component({
  selector: 'app-tabla-reusable',
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './tabla-reusable.component.html',
  standalone: true,
  styleUrl: './tabla-reusable.component.css'
})
export class TablaReusableComponent  implements OnInit {
  @Input() columnas: {field:string; header:string}[] = [];
  @Input() data:any[] = [];
  @Input() title: string = '';
  @Output() edit = new EventEmitter<any>();
  @Output() delete = new EventEmitter<any>();
  @Output() create = new EventEmitter<void>();
  isAdmin:boolean = false;
  constructor(private authService: AuthService) {}
  ngOnInit(): void {
    this.isAdmin = this.authService.hasRole('ROLE_ADMIN');
  }
  onEdit(item: any): void {
    this.edit.emit(item);
  }

  onDelete(item: any): void {
    this.delete.emit(item);
  }

  onCreate(): void {
    this.create.emit();
  }
}
