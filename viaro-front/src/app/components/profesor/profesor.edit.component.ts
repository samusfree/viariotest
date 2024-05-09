
import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import {
  DynamicDialogComponent,
  DynamicDialogConfig,
  DynamicDialogRef,
} from 'primeng/dynamicdialog';
import { Profesor } from '../../models/profesor';
import { ProfesorService } from '../../services/profesor.service';

@Component({
  selector: 'app-profesor-edit',
  templateUrl: './profesor.edit.component.html',
})
export class ProfesorEditComponent implements OnInit {
  id!: number | null;
  instance: DynamicDialogComponent | undefined;
  data: Profesor;
  generoOptions: any[] = [
    { name: 'Masculino', value: 'M' },
    { name: 'Femenino', value: 'F' },
  ];

  constructor(
    public ref: DynamicDialogRef,
    private profesorService: ProfesorService,
    private dialogConfig: DynamicDialogConfig
  ) {
    this.data = new Profesor();
  }

  ngOnInit() {
    if (this.dialogConfig && this.dialogConfig.data) {
      this.id = this.dialogConfig.data['id'];
    }

    if (this.id != undefined && this.id !== null) {
      this.profesorService.get(this.id).subscribe((value) => {
        this.data = value;
      });
    }
  }

  save() {
    let returnValue: Observable<void>;
    returnValue =
      this.id != undefined && this.id !== null
        ? this.profesorService.update(this.data)
        : this.profesorService.save(this.data);
    returnValue.subscribe((x) => {
      this.cerrar();
    });
  }

  cerrar() {
    this.ref.close();
  }
}
