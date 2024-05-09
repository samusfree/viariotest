import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule } from  '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { AppComponent } from './app.component';
import { MenuModule } from 'primeng/menu';
import { TableModule } from 'primeng/table';
import { PanelModule } from 'primeng/panel';
import { ToolbarModule } from 'primeng/toolbar';
import { ButtonModule } from 'primeng/button';
import { DynamicDialogModule } from 'primeng/dynamicdialog';
import { CardModule } from 'primeng/card';
import { FieldsetModule } from 'primeng/fieldset';
import { InputTextModule } from 'primeng/inputtext';
import { SelectButtonModule } from 'primeng/selectbutton';
import { CalendarModule } from 'primeng/calendar';
import { DropdownModule } from 'primeng/dropdown';
import { MenuComponent } from './components/menu/menu.component';
import { KeyFilterModule } from 'primeng/keyfilter';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { ToastModule } from 'primeng/toast';
import { AlumnoComponent } from './components/alumno/alumno.component';
import { AlumnoEditComponent } from './components/alumno/alumno.edit.component';
import { ProfesorComponent } from './components/profesor/profesor.component';
import { ProfesorEditComponent } from './components/profesor/profesor.edit.component';
import { GradoComponent } from './components/grado/grado.component';
import { GradoEditComponent } from './components/grado/grado.edit.component';
import { AlumnoGradoComponent } from './components/alumno-grado/alumno-grado.component';
import { AlumnoGradoEditComponent } from './components/alumno-grado/alumno-grado.edit.component';

@NgModule({
  declarations: [
    AppComponent, 
    MenuComponent,
    AlumnoComponent,
    AlumnoEditComponent,
    ProfesorComponent,
    ProfesorEditComponent,
    GradoComponent,
    GradoEditComponent,
    AlumnoGradoComponent,
    AlumnoGradoEditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    FormsModule,
    MenuModule,
    TableModule,
    PanelModule,
    ToolbarModule,
    ButtonModule,
    DynamicDialogModule,
    CardModule,
    FieldsetModule,
    InputTextModule,
    SelectButtonModule,
    ConfirmDialogModule,
    CalendarModule,
    DropdownModule,
    KeyFilterModule,
    ToastModule
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
