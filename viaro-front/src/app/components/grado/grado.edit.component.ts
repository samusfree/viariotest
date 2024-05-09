import { Component, OnInit } from '@angular/core';
import { Alumno } from '../../models/alumno';
import { AlumnoService } from '../../services/alumno.service';
import { Observable } from 'rxjs';
import {
  DialogService,
  DynamicDialogComponent,
  DynamicDialogConfig,
  DynamicDialogRef,
} from 'primeng/dynamicdialog';
import { GradoService } from '../../services/grado.service';
import { Grado } from '../../models/grado';
import { ProfesorService } from '../../services/profesor.service';
import { Profesor } from '../../models/profesor';
import { ResponseDTO } from '../../models/response';
import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-grado-edit',
  templateUrl: './grado.edit.component.html',
  providers: [MessageService]
})
export class GradoEditComponent implements OnInit {
  id!: number | null;
  instance: DynamicDialogComponent | undefined;
  data: Grado;
  profesores!: Profesor[];

  constructor(
    public ref: DynamicDialogRef,
    private gradoService: GradoService,
    private profesorService: ProfesorService,
    private dialogConfig: DynamicDialogConfig,
    private messageService: MessageService
  ) {
    this.data = new Grado();
  }

  ngOnInit() {
    this.cargarProfesores();
    if (this.dialogConfig && this.dialogConfig.data) {
      this.id = this.dialogConfig.data['id'];
    }

    if (this.id != undefined && this.id !== null) {
      this.gradoService.get(this.id).subscribe((value) => {
        this.data = value;
      });
    }
  }

  save() {
    let returnValue: Observable<ResponseDTO<Grado>>;
    returnValue =
      this.data.id !== undefined && this.data.id !== null
        ? this.gradoService.update(this.data)
        : this.gradoService.save(this.data);
    returnValue.subscribe((data) => {
      if(!data.success) {
        this.messageService.add({ severity: 'error', summary: 'Error', detail: data.message });
      }
      if(data.success) {
        this.messageService.add({ severity: 'success', summary: 'Exito', detail: 'Operación exitosa' });
        this.cerrar();
      }
    });
  }

  cerrar() {
    this.ref.close();
  }

  cargarProfesores() {
    this.profesorService.list().subscribe(value => {
      this.profesores = value;
      this.profesores.forEach(x => x.nombreCompleto = x.nombre + " " + x.apellidos);
    });
  }
}
