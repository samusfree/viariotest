import { Component, OnInit } from '@angular/core';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { ProfesorEditComponent } from './profesor.edit.component';
import { Profesor } from '../../models/profesor';
import { ProfesorService } from '../../services/profesor.service';

@Component({
  selector: 'app-profesor',
  templateUrl: './profesor.component.html',
  providers: [DialogService],
})
export class ProfesorComponent implements OnInit {
  data!: Profesor[];
  ref: DynamicDialogRef | undefined;

  constructor(
    private profesorService: ProfesorService,
    public dialogService: DialogService
  ) {}

  ngOnInit() {
    this.actualizarLista();
  }

  agregar(id: number | null) {
    this.ref = this.dialogService.open(ProfesorEditComponent, {
      data: {
        id: id,
      },
      header: id === null ? 'Agregar profesor' : 'Editar profesor',
      width: '50vw',
      modal: true,
      breakpoints: {
        '960px': '75vw',
        '640px': '90vw',
      },
    });

    this.ref.onClose.subscribe(() => {
        this.actualizarLista();
    });
  }
  
  actualizarLista() {
    this.profesorService.list().subscribe((value) => {
        this.data = value;
      });
  }

  eliminar(id: number) {
    this.profesorService.delete(id).subscribe(x => {
      this.actualizarLista();
    });
  }
}
