import { Component, OnInit } from '@angular/core';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { AlumnoGradoEditComponent } from './alumno-grado.edit.component';
import { AlumnoGrado } from '../../models/alumno-grado';
import { AlumnoGradoService } from '../../services/alumno-grado.service';

@Component({
  selector: 'app-alumno-grado',
  templateUrl: './alumno-grado.component.html',
  providers: [DialogService],
})
export class AlumnoGradoComponent implements OnInit {
  data!: AlumnoGrado[];
  ref: DynamicDialogRef | undefined;

  constructor(
    private alumnoGradoService: AlumnoGradoService,
    public dialogService: DialogService
  ) {}

  ngOnInit() {
    this.actualizarLista();
  }

  agregar(id: number | null) {
    this.ref = this.dialogService.open(AlumnoGradoEditComponent, {
      data: {
        id: id,
      },
      header: id === null ? 'Agregar alumno grado' : 'Editar alumno grado',
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
    this.alumnoGradoService.list().subscribe((value) => {
        this.data = value;
      });
  }

  eliminar(id: number) {
    this.alumnoGradoService.delete(id).subscribe(x => {
      this.actualizarLista();
    });
  }
}
