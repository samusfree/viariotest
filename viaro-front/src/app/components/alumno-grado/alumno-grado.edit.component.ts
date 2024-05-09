import { Component, OnInit } from '@angular/core';
import { Alumno } from '../../models/alumno';
import { AlumnoService } from '../../services/alumno.service';
import { Observable } from 'rxjs';
import {
  DynamicDialogComponent,
  DynamicDialogConfig,
  DynamicDialogRef,
} from 'primeng/dynamicdialog';
import { GradoService } from '../../services/grado.service';
import { Grado } from '../../models/grado';
import { AlumnoGradoService } from '../../services/alumno-grado.service';
import { AlumnoGrado } from '../../models/alumno-grado';

@Component({
  selector: 'app-alumno-grado-edit',
  templateUrl: './alumno-grado.edit.component.html',
})
export class AlumnoGradoEditComponent implements OnInit {
  id!: number | null;
  instance: DynamicDialogComponent | undefined;
  data: AlumnoGrado;
  alumnos!: Alumno[];
  grados!: Grado[];

  constructor(
    public ref: DynamicDialogRef,
    private gradoService: GradoService,
    private alumnoService: AlumnoService,
    private alumnoGradoService: AlumnoGradoService,
    private dialogConfig: DynamicDialogConfig
  ) {
    this.data = new AlumnoGrado();
  }

  ngOnInit() {
    this.cargarAlumnos();
    this.cargarGrados();
    if (this.dialogConfig && this.dialogConfig.data) {
      this.id = this.dialogConfig.data['id'];
    }

    if (this.id != undefined && this.id !== null) {
      this.alumnoGradoService.get(this.id).subscribe((value) => {
        this.data = value;
      });
    }
  }

  save() {
    let returnValue: Observable<void>;
    returnValue =
      this.data.id !== undefined && this.data.id !== null
        ? this.alumnoGradoService.update(this.data)
        : this.alumnoGradoService.save(this.data);
    returnValue.subscribe((x) => {
      this.cerrar();
    });
  }

  cerrar() {
    this.ref.close();
  }

  cargarAlumnos() {
    this.alumnoService.list().subscribe(value => {
      this.alumnos = value;
      this.alumnos.forEach(x => x.nombreCompleto = x.nombre + " " + x.apellidos);
    });
  }

  cargarGrados() {
    this.gradoService.list().subscribe(value => {
      this.grados = value;
    });
  }
}
