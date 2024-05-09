import { Component, OnInit } from '@angular/core';
import { DialogService, DynamicDialogRef } from 'primeng/dynamicdialog';
import { GradoEditComponent } from './grado.edit.component';
import { Grado } from '../../models/grado';
import { GradoService } from '../../services/grado.service';

@Component({
  selector: 'app-grado',
  templateUrl: './grado.component.html',
  providers: [DialogService],
})
export class GradoComponent implements OnInit {
  data!: Grado[];
  ref: DynamicDialogRef | undefined;

  constructor(
    private gradoService: GradoService,
    public dialogService: DialogService
  ) {}

  ngOnInit() {
    this.actualizarLista();
  }

  agregar(id: number | null) {
    this.ref = this.dialogService.open(GradoEditComponent, {
      data: {
        id: id,
      },
      header: id === null ? 'Agregar grado' : 'Editar grado',
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
    this.gradoService.list().subscribe((value) => {
        this.data = value;
      });
  }

  eliminar(id: number) {
    this.gradoService.delete(id).subscribe(x => {
      this.actualizarLista();
    });
  }
}
