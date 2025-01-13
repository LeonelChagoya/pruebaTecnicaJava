import {Component, EventEmitter, Input, Output} from '@angular/core';
import {NgClass} from '@angular/common';

@Component({
  selector: 'app-modal-reutilizable',
  imports: [
    NgClass
  ],
  templateUrl: './modal-reutilizable.component.html',
  standalone: true,
  styleUrl: './modal-reutilizable.component.css'
})
export class ModalReutilizableComponent {
  @Input() title: string = '';
  @Input() visible: boolean = false;
  @Output() close = new EventEmitter<void>();
  @Output() submit = new EventEmitter<any>();
  onClose(): void {
    this.close.emit();
  }

  onSubmit(data: any): void {
    this.submit.emit(data);
  }
}
