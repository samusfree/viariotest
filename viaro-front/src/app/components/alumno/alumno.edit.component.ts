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

@Component({
  selector: 'app-alumno-edit',
  templateUrl: './alumno.edit.component.html',
})
export class AlumnoEditComponent implements OnInit {
  id!: number | null;
  instance: DynamicDialogComponent | undefined;
  alumno: Alumno;
  generos: any[] = [
    { name: 'Masculino', value: 'M' },
    { name: 'Femenino', value: 'F' },
  ];

  constructor(
    public ref: DynamicDialogRef,
    private alumnoService: AlumnoService,
    private dialogConfig: DynamicDialogConfig
  ) {
    this.alumno = new Alumno();
  }

  ngOnInit() {
    if (this.dialogConfig && this.dialogConfig.data) {
      this.id = this.dialogConfig.data['id'];
    }

    if (this.id != undefined && this.id !== null) {
      this.alumnoService.getAlumno(this.id).subscribe((value) => {
        this.alumno = value;
      });
    }
  }

  save() {
    let returnValue: Observable<void>;
    returnValue =
      this.id != undefined && this.id !== null
        ? this.alumnoService.update(this.alumno)
        : this.alumnoService.save(this.alumno);
    returnValue.subscribe((x) => {
      this.cerrar();
    });
  }

  cerrar() {
    this.ref.close();
  }
}
