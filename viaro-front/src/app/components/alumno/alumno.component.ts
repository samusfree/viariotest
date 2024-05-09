import { Component, OnInit } from '@angular/core';
import { Alumno } from '../../models/alumno';
import { AlumnoService } from '../../services/alumno.service';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { AlumnoEditComponent } from './alumno.edit.component';
import { ConfirmationService } from 'primeng/api';

@Component({
  selector: 'app-alumno',
  templateUrl: './alumno.component.html',
  providers: [DialogService, ConfirmationService],
})
export class AlumnoComponent implements OnInit {
  alumnos!: Alumno[];
  ref: DynamicDialogRef | undefined;

  constructor(
    private alumnoService: AlumnoService,
    public dialogService: DialogService,
    private confirmationService: ConfirmationService
  ) {}

  ngOnInit() {
    this.actualizarLista();
  }

  agregarAlumno(id: number | null) {
    this.ref = this.dialogService.open(AlumnoEditComponent, {
      data: {
        id: id,
      },
      header: id === null ? 'Agregar alumno' : 'Editar alumno',
      width: '50vw',
      height: '70vw',
      modal: true,
    });

    this.ref.onClose.subscribe(() => {
      this.actualizarLista();
    });
  }

  actualizarLista() {
    this.alumnoService.list().subscribe((value) => {
      this.alumnos = value;
      this.alumnos.forEach(
        (x) => (x.nombreCompleto = x.nombre + ' ' + x.apellidos)
      );
    });
  }

  confirmarEliminar(id: number, event: Event) {
    this.confirmationService.confirm({
      target: event.target as EventTarget,
      message: '¿Estás seguro de Eliminar?',
      header: 'Confirmación',
      icon: 'pi pi-exclamation-triangle',
      acceptIcon: 'none',
      rejectIcon: 'none',
      rejectButtonStyleClass: 'p-button-text',
      accept: () => {
        this.eliminarAlumno(id);
      },
      reject: () => {
      },
    });
  }

  eliminarAlumno(id: number) {
    this.alumnoService.delete(id).subscribe(x => {
      this.actualizarLista();
    });
  }
}
